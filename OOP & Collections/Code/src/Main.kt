abstract  class LibraryItem(val title: String, val ISBN :Int, val publication:String,val numberOfPages:Int ){
    abstract fun isAvailable(): Boolean
}

class Book( title: String,  ISBN :Int,  publication:String,  numberOfPages:Int,  var available:Boolean):LibraryItem( title ,ISBN , publication,numberOfPages){
    override fun isAvailable(): Boolean {
        return available
    }
}

class Magazine( title: String,  ISBN :Int,  publication:String,  numberOfPages:Int,  var available:Boolean):LibraryItem( title, ISBN , publication,numberOfPages){
    override fun isAvailable(): Boolean {
        return available
    }
}

class Journal( title: String,  ISBN :Int,  publication:String,  numberOfPages:Int,  var available:Boolean):LibraryItem( title, ISBN, publication,numberOfPages){
    override fun isAvailable(): Boolean {
        return available
    }
}

open class Person(val name:String, val id:Int)

data class Librarian(val n:String, val i:Int, val password : String): Person(n,i)

data class User(val n:String, val i:Int, val job : String): Person(n,i)

class LibraryDataBase{
        var currentLibrarians: MutableSet<Librarian> = mutableSetOf()
        var listOfAvailableBooks: MutableSet<Book>  = mutableSetOf()
        var listOfBorrowedBooks: MutableSet<Book> = mutableSetOf()
        var users: MutableSet<User> = mutableSetOf()
        var trackBorrowing: MutableMap<Book,User> = mutableMapOf()


        fun addLibrarian(librarian: Librarian) = currentLibrarians.add(librarian)
        fun getLibrarians()=  currentLibrarians.forEach {println(it.name+" "+it.id)}

        fun addUser(user:User) = users.add(user)
        fun getUsers()= users.forEach {println(it.name+" ")}


        fun addBook(book:Book) = listOfAvailableBooks.add(book)
        fun viewAvailableBooks()=listOfAvailableBooks.forEach {println(it.title+" "+it.ISBN)}

        fun lendBook(book:Book, user:User){
            listOfAvailableBooks.remove(book)
            listOfBorrowedBooks.add(book)
            trackBorrowing+=mapOf(book to user)
            book.available=false
        }
        fun viewBorrowedBooks()= listOfBorrowedBooks.forEach {println(it.title+" "+it.ISBN)}

        fun searchForABook (book: Book) {
             when {
                book.isAvailable() -> println(book.title+ " is available book")
                else -> println(book.title+ " is not available book")
        }
        }

        fun receiveBookFromBorrower(book: Book) {
            listOfBorrowedBooks.remove(book)
            listOfAvailableBooks.add(book)
            trackBorrowing.remove(book)
            book.available=true
            println("Received successfully")
        }

     fun track(book: Book){
         val borrower = trackBorrowing[book]
        if(borrower!=null){
            println("$borrower borrowed this book")

        }
         else {
             println(book.title+" is not borrowed yet")
        }
     }

}

fun main() {
    val lib=LibraryDataBase()

    // Add library items
    var book1=Book("Book1",1,"2025-1-13",200,true)
    var book2=Book("Book2",2,"2025-1-14",500,true)
    var magazine1=Magazine("Magazine1",1,"2025-1-15",20,true)
    var journal1=Journal("journal1",1,"2025-1-16",2,true)

    // Add librarian & User
    var librarian1= Librarian("Menna",1,"1234")
    var user1= User("user1",1,"Programmer")
    lib.addLibrarian(librarian1)
    lib.addUser(user1)

    // show users and librarians
    println("users are: ")
    lib.getUsers()
    println("librarians are: ")
    lib.getLibrarians()

    lib.addBook(book1)
    lib.addBook(book2)
    println("Available Books are: ")
    lib.viewAvailableBooks()

    lib.lendBook(book1,user1)
    lib.track(book1)
    println("Borrowed Books are: ")
    lib.viewBorrowedBooks()

    lib.receiveBookFromBorrower(book1)
    lib.searchForABook(book1)
    println("Available Books are: ")
    lib.viewAvailableBooks()
}