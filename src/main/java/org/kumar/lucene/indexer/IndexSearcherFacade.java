package org.kumar.lucene.indexer;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Paths;

import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

public class IndexSearcherFacade {

    final private IndexSearcher indexSearcher;

    public IndexSearcherFacade(String indexDirectoryPath) throws IOException {
        Paths.get(URI.create(indexDirectoryPath));
        Directory dir = FSDirectory.open(Paths.get(indexDirectoryPath));
        IndexReader reader = DirectoryReader.open(dir);
        indexSearcher = new IndexSearcher(reader);
    }

    public IndexSearcher getIndexSearcher() {
        return indexSearcher;
    }

}
