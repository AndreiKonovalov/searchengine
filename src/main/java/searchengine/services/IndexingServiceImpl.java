package searchengine.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import searchengine.config.Site;
import searchengine.config.SitesList;
import searchengine.dto.indexing.StartIndexingResponse;
import searchengine.repository.SiteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IndexingServiceImpl implements IndexingService{

//    private final SitesList sites;
    private final SiteRepository siteRepository;

    @Override
    public StartIndexingResponse startIndexing() {
        String[] errors = {"Индексация уже запущена", ""};
//        List<Site> sitesList = sites.getSites();
//        for(Site site : sitesList){
//            deleteAllInfoForSite(site.getUrl());
//        }

        StartIndexingResponse indexingResponse = new StartIndexingResponse();
        indexingResponse.setResult(true);
        indexingResponse.setError(errors[1]);

        return indexingResponse;
    }

    private void deleteAllInfoForSite(String url){
        siteRepository.deleteByUrlContaining(url);
    }
}
