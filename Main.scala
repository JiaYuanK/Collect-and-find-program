import scala.io.Source
import scala.io.StdIn.readLine
import scala.collection.mutable.ListBuffer
object Main{
    def main(args: Array[String]): Unit = {
        //Uses owid-covid-data.txt as source file
        val CSource = Source.fromFile("owid-covid-data.txt")
        //Creates a list where each element is a line from the text file 
        val Lines = CSource.getLines.toList
        //Asks the user for input
        val Userinput = readLine("Please type the Country Name:")
        //The list is filtered and returns the elements that contain the user input
        val Sorted = Lines.filter(_.contains(Userinput))
        //The list is filtered and returns the elements that contain Malaysia
        val SortedMalaysia = Lines.filter(_.contains("Malaysia"))
        //Creates a ListBuffer called Collect
        val CollectUserinput = new ListBuffer[Double]()
        //Creates a ListBuffer called CollectMalaysia
        val CollectMalaysia = new ListBuffer[Double]()
        //Close the file
        CSource.close
        for (line <- Sorted) {
            //Splits the list when there is a comma in the list
            val Sline = line.split(",")
            
            try{
                //Selects the element at index 7,then convert it to data type Double, the value is then assigned to variable d
                val d = Sline(7).toDouble
                // Appends the variable d to the Collect ListBuffer
                CollectUserinput += d
            }catch{
                //If there is an Empty space, sets variable d to 0.0 and appends it to the ListBuffer
                case e: NumberFormatException => 
                val d = 0.0
                CollectUserinput += d
            }
        }
        for (line <- SortedMalaysia) {
            //Splits the list when there is a comma in the list
            val Sline = line.split(",")
            
            try{
                //Selects the element at index 7,then convert it to data type Double, the value is then assigned to variable d
                val d = Sline(7).toDouble
                // Appends the variable d to the Collect ListBuffer
                CollectMalaysia += d
            }catch{
                //If there is an Empty space, sets variable d to 0.0 and appends it to the ListBuffer
                case e: NumberFormatException => 
                val d = 0.0
                CollectMalaysia += d
            }
        }
        //Converts the ListBuffer to a list
        // ListBuffer is mutable implementation, changing this to list will it immutable and maintains the order
        val CompleteListUserinput = CollectUserinput.toList
        val CompleteListMalaysia = CollectMalaysia.toList
        //Returns the lenght of the list 
        val daysUserinput = CompleteListUserinput.length
        //Calculates the Average death per day
        val averagedeathUserinput = CompleteListUserinput.max / daysUserinput
        println("The total deaths for Malaysia is " +CompleteListMalaysia.max )
        
        println("The average death for "+ Userinput + " is " + averagedeathUserinput)
        
    } 
    
}