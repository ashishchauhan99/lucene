package org.kumar.lucene;

import java.io.IOException;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.kumar.lucene.document.DocumentFacade;
import org.kumar.lucene.indexer.IndexWriterFacade;

public class LuceneStarter {

    final static String dataDir = "D:\\Lucene\\documents";
    final static String indexDir = "D:\\Lucene\\index";

    public static void main(String[] args) throws IOException {
        LuceneStarter luceneStarter = new LuceneStarter();
        luceneStarter.createIndex(dataDir, indexDir);
    }

    private void createIndex(String dataDir, String indexDir) throws IOException {
        IndexWriterFacade indexWriterFacade = new IndexWriterFacade(indexDir, new StandardAnalyzer());
        DocumentFacade documentFacade = new DocumentFacade(dataDir);
        indexWriterFacade.createIndex(documentFacade.getPreparedDocuments());
    }

}
