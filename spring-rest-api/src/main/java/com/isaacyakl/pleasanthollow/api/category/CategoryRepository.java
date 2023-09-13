package com.isaacyakl.pleasanthollow.api.category;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, UUID> {

    public List<Category> findByParentId(UUID parentId);

}
