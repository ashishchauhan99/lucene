# lucene
For learning different lucene library capabalities.

# Goals
- Show usage of StandardAnalyzer
    - Extend Stop Word list    
- Use HindiAnalyzer
- Use StemFilter and SynonameFilter
- Combine StemFilter and SynonameFilter with StandarAnalyzer

# Example Reference         
https://howtodoinjava.com/lucene/lucene-index-search-examples
https://www.tutorialspoint.com/lucene/lucene_first_application.htm

# Other Utilites 
Apache Tikka library is used in combination to Lucene to get content from rich documents (PDF, Word etc)

# Document
- Document is the the collection of {@ Field}
- The Index Field are predefined all the implementations of {@ IndexableField}
- A custom field can be defined by creating own {@ Field}

# Sorting
- Sorting is done on the bases of Score of each Document
- Socring is calculated on the bases of 1. Vector Space Model and 2. Boolean Model
- In general, the idea behind the VSM is the more times a query term appears in a document relative to the number of times the term appears in all the documents in the collection, the more - relevant that document is to the query. 
- Boolean Scoring is done Before Vactor Space to narrow done the result.
- Read this: https://lucene.apache.org/core/2_9_4/scoring.html

# Boosting
- Score of a Document can be manuplated by Boosting.
- There are three type of boosting document.setBoost() , field.setBoost() , Query.setBoost().
- Read this: https://lucene.apache.org/core/2_9_4/scoring.html

# Term Vector
- When a custom field is defined it can be take one of the following TermVector value
- TermVector.YES—Records the unique terms that occurred, and their counts, in each document, but doesn’t store any positions or offsets information
- TermVector.WITH_POSITIONS—Records the unique terms and their counts, and also the positions of each occurrence of every term, but no offsets
- TermVector.WITH_OFFSETS—Records the unique terms and their counts, with the offsets (start and end character position) of each occurrence of every term, but no positions
- TermVector.WITH_POSITIONS_OFFSETS—Stores unique terms and their counts, along with positions and offsets
- Which one to use  Read here: https://stackoverflow.com/questions/13208609/which-term-vector-option-to-use-in-lucene 
- Lucen in Action book also explain when to use which one

# Creating Document and Field
      
- The following field will be used to tokenized the content of file and search against those token, it wil not store the whole content of that file. This field is not Term_Vector that means it will not play any role in sorting. All the sub class of {@ Field} are non Term_Vectored. If you want to define a field as Term_Vectored then use directly use constructor of {@ Field} and pass {@ IndexableFieldType} 

```
 TextField content = new TextField("content", "file-Content", Store.NO);
```

- We want to store the name of our file as Document part so it remains available in return result.

```
StringField name = new StringField("name", file.getName(), Store.YES);
StringField fullPath = new StringField("fullPath", file.getAbsolutePath(), Store.YES);
```

# MultiFieldQueryParser
- MultiFieldQueryParser is used to look for the same value against different fields

```
Query query = MultiFieldQueryParser.parse(Version.LUCENE_30, new String[] {"harry potter","harry potter","harry potter"},   new String[] {"title","author","content"},new SimpleAnalyzer());
IndexSearcher searcher = new IndexSearcher(...);
Hits hits = searcher.search(query);                  
```

# QueryParser
- syntax: https://lucene.apache.org/core/2_9_4/queryparsersyntax.html#Fuzzy%20Searches

# Luke
-  This is a GUI for lucene. You can execute and test you quires with this.

 