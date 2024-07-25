fun main() {
    var newCar = Car("red", "Mazda", "MX-3", "4")  // Create a new car instance
    println(newCar.toString())  // Print the car's details
    newCar.accelerate(6.1, 110.0)  // Call the accelerate method with an acceleration of 6.1 m/s²
    newCar.fullStop(130.0, 14.2)  // Call the fullStop method with a speed of 130 km/h and deceleration of 14.2 m/s²
    newCar.parallelPark()  // Call the parallelPark method

    val newBus = Bus("yellow", "Volvo", "B340", 50)  // Create a new bus instance
    println(newBus.toString())  // Print the bus's details
    newBus.accelerate(4.5, 120.0)  // Call the accelerate method with an acceleration of 4.5 m/s²
    newBus.fullStop(80.0, 10.0)  // Call the fullStop method with a speed of 80 km/h and deceleration of 10 m/s²
    newBus.openRearDoor()  // Call the openRearDoor method
}



abstract class Vehicle(var color: String, val make: String, val model: String) {
    abstract fun accelerate(acceleration: Double, distance: Double): Double  
    // Abstract method to calculate the time to reach 100 km/h given the acceleration
    abstract fun fullStop(speed: Double, deceleration: Double): Double  
    // Abstract method to calculate the time to stop from a given speed and deceleration
}


class Car(color: String, make: String, model: String, var numberOfDoors: String) : Vehicle(color, make, model) {
    override fun accelerate(acceleration: Double, distance: Double): Double {  
        val timeRate = distance / acceleration  // Calculate the time to reach 100 km/h
        println("Your vehicle's acceleration from 0 km/h to ${distance} km/h is %.2f seconds".format(timeRate))  // Print the acceleration time
        return timeRate  // Return the calculated time
    }

    override fun fullStop(speed: Double, deceleration: Double): Double {  
        val fullStopTime = speed / deceleration  // Calculate the time to stop from the given speed and deceleration
        println("Your vehicle will fully stop from $speed km/h to 0 km/h in %.2f seconds".format(fullStopTime))  // Print the stopping time
        return fullStopTime  // Return the calculated stopping time
    }

    override fun toString(): String {  
        return """
        Car

Model: $model
Make: $make
Number of doors: $numberOfDoors        
""".trimIndent()  // Format and return the car's details with lining the code to the left
    }

    fun parallelPark() {  
        println("""    
             Parallel parking the car...

Step 1: Pull up parallel to the car in front of the space.
Step 2: Reverse into the space while turning the wheel towards the curb.
Step 3: Straighten the wheel and continue reversing.
Step 4: Turn the wheel away from the curb and reverse to adjust.
Step 5: Straighten the wheel and center the car in the space.
Parallel parking completed.
""".trimIndent())  // Print the steps for parallel parking
    }
}

class Bus(color: String, make: String, model: String, var passengerCapacity: Int) : Vehicle(color, make, model) {
    override fun accelerate(acceleration: Double, distance: Double): Double {  
        val timeRate = distance / acceleration  // Calculate the time to reach 100 km/h
        println("The bus accelerates from 0 km/h to ${distance} km/h in %.2f seconds".format(timeRate))  // Print the acceleration time
        return timeRate  // Return the calculated time
    }

    override fun fullStop(speed: Double, deceleration: Double): Double {  
        val fullStopTime = speed / deceleration  // Calculate the time to stop from the given speed and deceleration
        println("The bus will fully stop from $speed km/h to 0 km/h in %.2f seconds".format(fullStopTime))  // Print the stopping time
        return fullStopTime  // Return the calculated stopping time
    }

    fun openRearDoor() {  
        println("Opening the rear door...")  // Print a message indicating the rear door is opening
        println("The rear door is now open.")  // Print a message indicating the rear door is open
    }

    override fun toString(): String {  
       return """

        Bus
        
Model: $model
Make: $make
Passenger Capacity: $passengerCapacity 
        """.trimIndent()  // Format and return the bus's details with lining the code to the left
    }
}
