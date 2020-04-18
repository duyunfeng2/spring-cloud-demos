package com.asiainfo.user.repository;

import com.asiainfo.user.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 2020/4/9 16:13
 * creator dufy
 */
@Repository
public class UserRepository {
	private ConcurrentHashMap repository = new ConcurrentHashMap();
	private static final AtomicLong idGenerator = new AtomicLong(0);

	public boolean save(User user) {
		Long id = idGenerator.incrementAndGet();
		user.setId(id);
		// repository.putIfAbsent(id,user) == null 如果是 == null 表示成功插入
		// putIfAbsent 如果已经有值的话，则有返回值，即防止表单重复提交的作用
		return repository.putIfAbsent(id,user) == null;
	}

	public Collection<User> findAll() {
		return repository.values();
	}
}
