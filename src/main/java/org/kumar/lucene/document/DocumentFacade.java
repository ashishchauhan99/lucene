package org.kumar.lucene.document;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;

public class DocumentFacade {

    private File dataDir;

    public DocumentFacade(String dataDir) {
        this.dataDir = new File(dataDir);
    }

    public Set<Document> getPreparedDocuments() throws IOException {

        Set<Document> documents = new HashSet<Document>();

        for (File file : dataDir.listFiles()) {

            /**
             * FileReader is automatically closed by {@ IndexWriter#addDocuments} Reader is important to use to we do
             * not load everthing into memory.
             */

            FileReader fileReader = new FileReader(file);

            Document document = new Document();
            /**
             * the content of file we just want to tokenized and search against those token, but we do not want to store
             * the whole content of that file. This field is not Term_Vector that means it will not play any role in
             * sorting.
             * 
             * All the sub class of {@ Field} are non Term_Vectored. If you want to define a field as Term_Vectored then
             * use directly use constructor of {@ Field} and pass {@ IndexableFieldType}
             * 
             */

            TextField content = new TextField("content", fileReader);

            // TextField content = new TextField("content", "file-Content", Store.NO);

            /**
             * We want to store the name of our file as Document part so it remains available in return result.
             */
            StringField name = new StringField("name", file.getName(), Store.YES);
            StringField fullPath = new StringField("fullPath", file.getAbsolutePath(), Store.YES);

            document.add(content);
            document.add(name);
            document.add(fullPath);

            documents.add(document);

        }

        return documents;
    }

}
