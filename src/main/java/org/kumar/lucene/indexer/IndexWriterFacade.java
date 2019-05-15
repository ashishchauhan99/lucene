package org.kumar.lucene.indexer;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Set;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;

public class IndexWriterFacade {

    private IndexWriter indexWriter;

    public IndexWriterFacade(String writeIndexDirectoryPath, Analyzer analyzer) throws IOException {
        FSDirectory dir = FSDirectory.open(Paths.get(writeIndexDirectoryPath));
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        indexWriter = new IndexWriter(dir, config);
    }

    public void createIndex(Set<Document> documents) throws IOException {
        indexWriter.deleteAll();
        indexWriter.addDocuments(documents);
        indexWriter.commit();
        indexWriter.close();
    }

}
