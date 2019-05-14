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
- Read this:https://lucene.apache.org/core/2_9_4/scoring.html

#Boosting
- Score of a Document can be manuplated by Boosting.
- There are three type of boosting document.setBoost() , field.setBoost() , Query.setBoost().
- Read this:https://lucene.apache.org/core/2_9_4/scoring.html

