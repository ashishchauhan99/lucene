# lucene
For learning different lucene library capabalities.

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



