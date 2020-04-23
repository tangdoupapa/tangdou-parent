package com.tangdou.common.service.impl;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import com.tangdou.common.base.annotation.Search;
import com.tangdou.common.base.request.PagerRequest;
import com.tangdou.common.dao.BaseRepository;
import com.tangdou.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.Id;
import javax.persistence.criteria.Predicate;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @Auther: tangdouopapa
 * @Date: 2020/3/29 09:27
 * @Description:
 */
public class BaseServiceImpl<R extends BaseRepository<T, ID>, T, ID> implements BaseService<R, T, ID> {

    @Autowired
    BaseRepository<T, ID> baseRepository;

    @Override
    public T save(T t) {
        return baseRepository.save(t);
    }

    @Override
    public T update(T t) {
        return baseRepository.save(t);
    }

    @Override
    public List<T> findAll() {
        return baseRepository.findAll();
    }

    @Override
    public void delete(ID id) {
        baseRepository.deleteById(id);
    }

    @Override
    public T findById(ID id) {
        return baseRepository.findById(id).orElse(null);
    }

    @Override
    public Page<T> findPage(PagerRequest pagerRequest) {
        return baseRepository.findAll(buildSpecification(pagerRequest), getPageable(pagerRequest));
    }

    @Override
    public Page<T> findPage(PagerRequest pagerRequest, Specification<T> specification) {
        buildSpecification(pagerRequest).and(specification);
        return baseRepository.findAll(buildSpecification(pagerRequest), getPageable(pagerRequest));
    }

    protected Specification<T> getSpec(String companyId) {
        /**
         * root: 对象数据   cb:构造查询条件
         */
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("companyId").as(String.class), companyId);
    }

    /**
     * 构建search条件
     *
     * @param pageRequest 分页数据
     * @return
     */
    protected Specification<T> buildSpecification(PagerRequest pageRequest) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = new ArrayList<>();
            if (StrUtil.isNotBlank(pageRequest.getSearch())) {
                // 通过注解标识需要搜索的字段
                Field[] fields = ReflectUtil.getFields(this.confirmGenericType());
                if (ArrayUtil.isNotEmpty(fields)) {
                    Stream.of(fields).forEach(f -> {
                        Search search = f.getAnnotation(Search.class);
                        if (ObjectUtil.isNotNull(search)) {
                            list.add(criteriaBuilder.like(root.get(f.getName()).as(String.class), pageRequest.getSearch()));
                        }
                    });
                }
                Optional<Field> primary = Stream.of(fields).filter(f -> ObjectUtil.isNotNull(f.getAnnotation(Id.class))).findAny();
                if (primary.isPresent()) {
                    list.add(criteriaBuilder.like(root.get(primary.get().getName()).as(String.class), pageRequest.getSearch()));
                }
            }
            return criteriaBuilder.and(ArrayUtil.toArray(list, Predicate.class));
        };
    }

    /**
     * 获取分页对象
     *
     * @param pagerRequest 分页数据
     * @return
     */
    protected Pageable getPageable(PagerRequest pagerRequest) {
        return PageRequest.of(pagerRequest.getCurrentPage() - 1, pagerRequest.getPageSize());
    }

    /**
     * 获取当前类 T泛型的真实类型
     *
     * @return 泛型T的Class
     */
    private Class<T> confirmGenericType() {
        // 获取当前对象的泛型的父类类型
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        // 获取 T 类型参数的真实类型
        return (Class<T>) pt.getActualTypeArguments()[1];
    }
}
