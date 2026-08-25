public class Car {
     String brand;
     String model;
     int year;
     boolean isRunning;

      Car(String brand, String model, int year, boolean isRunning){
         this.brand = brand;
         this.model = model;
         this.year = year;
         this.isRunning = isRunning;
      }

      public static void main(String[] args){
            Car car1 = new Car(
                        "Nissan", "Nissan GTR", 2003, true
                  );
            Car car2 = new Car(
                    "Toyota", "Toyota Supra", 2012, false
            );

            System.out.println(car1.brand + car1.isRunning + "\n");
            System.out.println(car2.brand + car2.isRunning);
      }
}



