package project.repositories;

import project.models.Site;

import java.util.List;

public interface SiteRepository extends CrudRepository<Long, Site> {
    List<Site> getPagination(Integer page, Integer size, String sort);

    int update(Long id, Site siteData);
}
