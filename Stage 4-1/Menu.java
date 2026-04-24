//Kobe Smith on 4/5/2026
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private Application app;
    
    public Menu(Application app) {
        this.app = app;
    }

    public void showMainMenu() {
        do {
            System.out.println("~~~~~Welcome to SkyHigh Airlines!~~~~~");
            System.out.println("Select user type:");
            System.out.println("1. Passenger");
            System.out.println("2. Staff");
            System.out.println("3. Manager");
            System.out.println("4. Human Resources");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    createPassenger();
                    break;
                case 2:
                    staffLogIn();
                    break;
                case 3:
                    managerLogIn();
                    break;
                case 4:
                    hrLogIn();
                    break;
                case 5:
                    System.out.println("Thank you for using SkyHigh Airlines. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        } while (true);
    }

    public void createPassenger() {
        do {
            System.out.println("\nPassenger Options:");
            System.out.println("1. Create Passenger Account");
            System.out.println("2. Log in");
            System.out.println("3. Back to Main Menu");
            System.out.print("Choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    String name, email, pnr;

                    System.out.print("Enter your name: ");
                    name = sc.nextLine();
                    System.out.print("Enter your email: "); 
                    email = sc.nextLine();
                    System.out.print("Enter your PNR: ");
                    pnr = sc.nextLine();

                    System.out.println("\nCreating passenger account...");
                    Passenger passenger = new Passenger(name, email, pnr);
                    app.getUserLog().addPassenger(passenger);
                    //edited to add newly created passenger to flight manager 
                    app.getFlightManager().addNewPassenger(passenger);
                    System.out.println("Account created successfully for " + name + " with PNR: " + pnr);
                    System.out.println("A confirmation email has been sent to " + email + "\n");
                    break;
                case 2:
                    String nameLogin, pnrLogin;

                    System.out.print("Enter your name: ");
                    nameLogin = sc.nextLine();
                    System.out.print("Enter your PNR: ");
                    pnrLogin = sc.nextLine();

                    for (Passenger p : app.getUserLog().getPassengerLog()) {
                        if (p.getName().equalsIgnoreCase(nameLogin)) {
                            System.out.println("Login successful! Welcome back, " + nameLogin + "!\n");
                            showPassengerMenu(p);
                            return;
                        }
                    }
                    System.out.println("Invalid credentials. Please try again.\n");
                    // Code to log in
                    break;
                case 3:
                    System.out.println("Returning to Main Menu...\n");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        } while (true);
    }

    public void showPassengerMenu(Passenger passenger) {
        do {
            System.out.println("\nPassenger Menu:");
            System.out.println("1. Book a Flight");
            System.out.println("2. View Tickets");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Update Information");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Available Flights:");
                    for (Flight f : app.getFlightManager().flightList()) {
                        System.out.println(f.getFlightID() + " - " + f.getOrigin() + " to " + f.getDestination() + " at " + f.getDepartureTime());
                    }
                    System.out.print("Enter the Flight ID you want to book: ");
                    String flightID = sc.nextLine();
                
                    for (Flight f : app.getFlightManager().flightList()) {
                        if (f.getFlightID().equalsIgnoreCase(flightID)) {
                            System.out.println("You selected flight " + f.getFlightID());
                        }
                    }

                    System.out.println("\nAvailable Ticket Types:");
                    for (Ticket t : app.getTicketManager().getTicketTypes()) {
                        System.out.println(t.toString());
                    }
                    
                    System.out.print("Ticket type (View Ticket Types Above): ");
                    String ticketType = sc.nextLine();

                    double amount;
                    String TicketId;
                    if (ticketType.equalsIgnoreCase("Economy")) {
                        Ticket ticket = new Ticket(ticketType, "#T101", passenger.getPnr(), 0.0);
                        amount = ticket.getEconPrice();
                        TicketId = ticket.getEconTicketId();
                        //app.getTicketManager().addTicket(ticket);
                    } else if (ticketType.equalsIgnoreCase("Premium")) {
                        Ticket ticket = new Ticket(ticketType, "#T102", passenger.getPnr(), 0.0);
                        amount = ticket.getPremPrice();
                        TicketId = ticket.getPremTicketId();
                        //app.getTicketManager().addTicket(ticket);
                    } else if (ticketType.equalsIgnoreCase("Business")) {
                        Ticket ticket = new Ticket(ticketType, "#T103", passenger.getPnr(), 0.0);
                        amount = ticket.getBusPrice();
                        TicketId = ticket.getBusTicketId();
                        //app.getTicketManager().addTicket(ticket);
                    } else if (ticketType.equalsIgnoreCase("First Class")) {
                        Ticket ticket = new Ticket(ticketType, "#T104", passenger.getPnr(), 0.0);
                        amount = ticket.getFirstPrice();
                        TicketId = ticket.getFirstTicketId();
                        //app.getTicketManager().addTicket(ticket);
                    } else {
                        System.out.println("Invalid ticket type! Please try again.");
                        break;
                    }
                    System.out.println("Total cost: $" + amount);

                    System.out.print("\nCard or Cash? ");
                    String paymentMethod = sc.nextLine();
                    if (paymentMethod.equalsIgnoreCase("Card")) {
                        System.out.print("Enter name on card: ");
                        String cardName = sc.nextLine();
                        System.out.print("Enter card number: ");
                        String cardNumber = sc.nextLine();
                        System.out.print("Enter expiration date (MM/YY): ");
                        String expirationDate = sc.nextLine();
                        System.out.print("Enter CVV: ");
                        int cvv = sc.nextInt();
                        sc.nextLine();

                        Payment card = new Card(amount, cardName, cardNumber, expirationDate, cvv);
                        app.getPaymentProcessor().processPayment(card, amount, passenger, "Confirmed");
                        app.getTicketManager().addPassengerTicket(new Ticket(ticketType, TicketId, passenger.getPnr(), amount), passenger, flightID);
                        //edited to add purchased ticket to flight manager
                        app.getFlightManager().addTicket(new Ticket(ticketType, TicketId, passenger.getPnr(), amount));
                        break;
                    } else if (paymentMethod.equalsIgnoreCase("Cash")) {
                        System.out.print("Enter name on cash payment: ");
                        String cashName = sc.nextLine();

                        Payment cash = new Cash(amount, cashName);
                        app.getPaymentProcessor().processPayment(cash, amount, passenger, "Confirmed");
                        app.getTicketManager().addPassengerTicket(new Ticket(ticketType, TicketId, passenger.getPnr(), amount), passenger, flightID);
                        //edited to add purchased ticket to flight manager
                        app.getFlightManager().addTicket(new Ticket(ticketType, TicketId, passenger.getPnr(), amount));
                        break;
                    } else {
                        System.out.println("Invalid payment method! Please try again.");
                        break;
                    }
                case 2:
                    System.out.print("Enter your PNR to view tickets: ");
                    String pnr = sc.nextLine();
                    System.out.println("Your Tickets:");
                    for (String ticketInfo : app.getTicketManager().getPassengerTickets()) {
                        if (ticketInfo.contains(pnr)) {
                            System.out.println(ticketInfo);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter the Flight ID of the booking to cancel: ");
                    String cancelFlightID = sc.nextLine();
                    System.out.print("Enter your PNR to confirm cancellation: ");
                    String cancelPnr = sc.nextLine();

                    System.out.println("Cancelling booking...");
                    for (String ticketInfo : app.getTicketManager().getPassengerTickets()) {
                        if (ticketInfo.contains(cancelPnr) && ticketInfo.contains(cancelFlightID)) {
                            System.out.println("Booking cancelled successfully for flight " + cancelFlightID + " with PNR: " + cancelPnr);
                            app.getTicketManager().removePassengerTicket(ticketInfo);
                            app.getFlightManager().removePassengerTicket(ticketInfo);
                            break;
                        }
                    }
                    break;
                case 4:
                    //New case to update Passenger info
                    String Pnr, toUpdate;
                    System.out.println("Enter your PNR: ");
                    Pnr = sc.nextLine();
                    System.out.print("What do you Wish to Update (name or email)? ");
                    toUpdate = sc.nextLine();

                    for (Passenger p : app.getUserLog().getPassengerLog())
                        if (Pnr.equalsIgnoreCase(p.getPnr())) {
                            if (toUpdate.equalsIgnoreCase("name")) {
                                System.out.print("Enter New Name: ");
                                String name = sc.nextLine();
                                p.setName(name);
                            }
                            else if (toUpdate.equalsIgnoreCase("email")) {
                                System.out.print("Enter New Email: ");
                                String email = sc.nextLine();
                                p.setEmail(email);
                            }
                        }
                case 5:
                    System.out.println("Returning to Main Menu...\n");
                return;
            }
        } while (true);
    }

    public void staffLogIn() {
        do {
            System.out.println("\nStaff Login:");
            System.out.println("1. General Staff Log in");
            System.out.println("2. Cockpit Crew Log in");
            System.out.println("3. Flight Attendant Log in");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    String nameLogin;
                    int staffIDLogin;

                    System.out.print("Enter your name: ");
                    nameLogin = sc.nextLine();
                    System.out.print("Enter your Staff ID: ");
                    staffIDLogin = sc.nextInt();
                    sc.nextLine();

                    for (Staff s : app.getUserLog().getStaffLog()) {
                        if (s.getName().equalsIgnoreCase(nameLogin) && s.getStaffID() == staffIDLogin) {
                            System.out.println("Login successful! Welcome back, " + nameLogin + "!\n");
                            showStaffMenu();
                            return;
                        }
                    }
                    System.out.println("Invalid credentials. Please try again.\n");
                    return;
                case 2:
                    String cockpitName;
                    int cockpitID;
                    System.out.print("Enter your name: ");
                    cockpitName = sc.nextLine();
                    System.out.print("Enter your Staff ID: ");
                    cockpitID = sc.nextInt();
                    sc.nextLine();

                    for (Staff c : app.getUserLog().getStaffLog()) {
                        if (c.getName().equalsIgnoreCase(cockpitName) && c.getStaffID() == cockpitID) {
                            System.out.println("Login successful! Welcome back, " + cockpitName + "!\n");
                            showCockpitMenu();
                            return;
                        }
                    }
                    System.out.println("Invalid credentials. Please try again.\n");
                    return;
                case 3:
                    String attendantName;
                    int attendantID;
                    System.out.print("Enter your name: ");
                    attendantName = sc.nextLine();
                    System.out.print("Enter your Staff ID: ");
                    attendantID = sc.nextInt();
                    sc.nextLine();

                    for (Staff f : app.getUserLog().getStaffLog()) {
                        if (f.getName().equalsIgnoreCase(attendantName) && f.getStaffID() == attendantID) {
                            System.out.println("Login successful! Welcome back, " + attendantName + "!\n");
                            showAttendantMenu();
                            return;
                        }
                    }
                    System.out.println("Invalid credentials. Please try again.\n");
                    return;
                case 4:
                    System.out.println("Returning to Main Menu...\n");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
                    return;
            }
        } while (true);
    }

    public void showCockpitMenu() {
        do {
            System.out.println("\nCockpit Crew Menu:");
            System.out.println("1. View Flight Schedule");
            System.out.println("2. View Assigned Flights");
            System.out.println("3. Fly aircraft");
            System.out.println("4. Land aircraft");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    app.createFlightSchedule();
                    break;
                case 2:
                    System.out.print("Enter your name to view assigned flights: ");
                    String name = sc.nextLine();
                    System.out.print("Enter your department to view assigned flights: ");
                    String department = sc.nextLine();

                    System.out.println("Viewing assigned flights...");
                    for (String s : app.getFlightManager().getStaffList()) {
                        if (s.contains(name) && s.contains(department)) {
                            System.out.println("- " + s);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter your name to view assigned flights: ");
                    String name2 = sc.nextLine();
                    System.out.print("Enter your department to view assigned flights: ");
                    String department2 = sc.nextLine();

                    System.out.println("Viewing assigned flights...");
                    for (String s : app.getFlightManager().getStaffList()) {
                        if (s.contains(name2) && s.contains(department2)) {
                            System.out.println("- " + s);
                        }
                    }
                    System.out.print("Enter the Flight ID of the flight you are flying: ");
                    String flightID2 = sc.nextLine();

                    for (String s : app.getFlightManager().getStaffList()) {
                        if (s.contains(flightID2)) {
                            app.getCockpitCrew().flyAircraft();
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter your name to view assigned flights: ");
                    String name1 = sc.nextLine();
                    System.out.print("Enter your department to view assigned flights: ");
                    String department1 = sc.nextLine();

                    System.out.println("Viewing assigned flights...");
                    for (String s : app.getFlightManager().getStaffList()) {
                        if (s.contains(name1) && s.contains(department1)) {
                            System.out.println("- " + s);
                        }
                    }

                    System.out.print("Enter the Flight ID of the flight you are flying: ");
                    String flightID = sc.nextLine();

                    for (String s : app.getFlightManager().getStaffList()) {
                        if (s.contains(flightID)) {
                            app.getCockpitCrew().landAircraft();
                            app.getFlightManager().removeStaffFromFlight(s);
                            break;
                        }
                    }
                    return;
                case 5:
                    System.out.println("Returning to Main Menu...\n");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
                    break;
            }
        } while (true);
    }

    public void showAttendantMenu() {
        do {
                System.out.println("\nFlight Attendant Menu:");
                System.out.println("1. View Flight Schedule");
                System.out.println("2. View Assigned Flights");
                System.out.println("3. Perform Safety Demonstration");
                System.out.println("4. Assist Passengers");
                System.out.println("5. Back to Main Menu");
                System.out.print("Choice: ");
                int choice = sc.nextInt();
                sc.nextLine();
    
                switch (choice) {
                    case 1:
                        app.createFlightSchedule();
                        break;
                    case 2:
                        System.out.print("Enter your name to view assigned flights: ");
                        String name = sc.nextLine();
                        System.out.print("Enter your department to view assigned flights: ");
                        String department = sc.nextLine();
    
                        System.out.println("Viewing assigned flights...");
                        for (String s : app.getFlightManager().getStaffList()) {
                            if (s.contains(name) && s.contains(department)) {
                                System.out.println("- " + s);
                            }
                        }
                        break;
                    case 3:
                        app.getFlightAttendants().performSafetyDemonstration();
                        break;
                    case 4:
                        app.getFlightAttendants().assistPassengers();
                        break;
                    case 5:
                        System.out.println("Returning to Main Menu...\n");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.\n");
                        break;
                }
        } while (true);
    }

    public void showStaffMenu() {
        do {
            System.out.println("General Staff Menu:");
            System.out.println("1. Clean Aircraft");
            System.out.println("2. Stock Supplies");
            System.out.println("3. Back to Main Menu");
            System.out.print("Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    app.getAircraftManager().displayFleet();
                    System.out.print("Enter the ID of the aircraft to clean: ");
                    String aircraftID = sc.next();
                    for (Aircraft a : app.getAircraftManager().getAircraftList()) {
                        if (a.getID().equalsIgnoreCase(aircraftID)) {
                            System.out.println("Cleaning aircraft " + a.getModel() + "...\n");
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Stocking supplies...\n");
                    break;
                case 3:
                    System.out.println("Returning to Main Menu...\n");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
                    break;
            }
        } while (true);
    }

    public void managerLogIn() {
        System.out.println("\nManager Login:");
        System.out.println("1. Log in");
        System.out.println("2. Back to Main Menu");
        System.out.print("Choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                String department;
                int staffIDLogin;

                System.out.print("Enter your Name: ");
                sc.nextLine(); //consume extra line
                name = sc.nextLine();
                System.out.print("Enter your Staff ID: ");
                staffIDLogin = sc.nextInt();
                sc.nextLine();

                for (Staff s : app.getUserLog().getStaffLog()) {
                    if (s.getStaffID() == staffIDLogin && s.getDepartment().equalsIgnoreCase(department)) {
                        if (department.equalsIgnoreCase("Aircraft Management")) {
                            System.out.println("Login successful! Welcome back, " + s.getName() + "!\n");
                            showAircraftManagerMenu();
                        } else if (department.equalsIgnoreCase("Flight Management")) {
                            System.out.println("Login successful! Welcome back, " + s.getName() + "!\n");
                            showFlightManagerMenu();
                        } else if (department.equalsIgnoreCase("Payment Processing")) {
                            System.out.println("Login successful! Welcome back, " + s.getName() + "!\n");
                            showPaymentProcessorMenu();
                        } else if (department.equalsIgnoreCase("Ticket Management")) {
                            System.out.println("Login successful! Welcome back, " + s.getName() + "!\n");
                            showTicketManagerMenu();
                        } else {
                            System.out.println("Invalid department. Please try again.\n");
                            break;
                        }
                    }
                }
                return;
            case 2:
                System.out.println("Returning to Main Menu...\n");
                break;
            default:
                System.out.println("Invalid choice. Please try again.\n");
                return;
        }
    }

    public void showAircraftManagerMenu() {
        do {
            System.out.println("\nAircraft Manager Menu:");
            System.out.println("1. View Aircraft List");
            System.out.println("2. Add New Aircraft");
            System.out.println("3. Remove Aircraft");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();


            switch (choice) {
                case 1:
                    System.out.println("Aircraft List:");
                    for (Aircraft a : app.getAircraftManager().getAircraftList()) {
                    System.out.println(a.getID() + " - " + a.getModel() + " - " + a.getCapacity() + " seats");
                    }
                    break;
                case 2:
                    String ID, model;
                    int capacity, staffNeeded;

                    System.out.print("Enter aircraft ID: ");
                    ID = sc.nextLine();
                    System.out.print("Enter aircraft model: ");
                    model = sc.nextLine();
                    System.out.print("Enter seating capacity: ");
                    capacity = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter staff needed: ");
                    staffNeeded = sc.nextInt();
                    sc.nextLine();

                    Aircraft newAircraft = new Aircraft(ID, model, capacity, staffNeeded);
                    app.getAircraftManager().addAircraft(newAircraft);
                    System.out.println("Aircraft added successfully: " + model + " with capacity of " + capacity + " seats.");
                    break;
                case 3:
                    System.out.print("Enter the ID of the aircraft to remove: ");
                    String aircraftID = sc.nextLine();
                    Aircraft toRemove = null;
                    for (Aircraft a : app.getAircraftManager().getAircraftList()) {
                        if (a.getID().equalsIgnoreCase(aircraftID)) {
                            toRemove = a;
                            break;
                        }
                    }
                    if (toRemove != null) {
                        app.getAircraftManager().removeAircraft(toRemove);
                        System.out.println("Aircraft removed successfully.");
                    } else {
                        System.out.println("Aircraft not found.");
                    }
                    break;
                case 4:
                    System.out.println("Returning to Main Menu...\n");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
                    break;
            }
        } while (true);
    }

    public void showFlightManagerMenu() {
        do {
            System.out.println("\nFlight Manager Menu:");
            System.out.println("1. View Flight Schedule");
            System.out.println("2. Add New Flight");
            System.out.println("3. Remove a Flight");
            System.out.println("4. View All Passengers");
            System.out.println("5. View All Staff Assigned to Flights");
            System.out.println("6. Assign Staff to Flight");
            System.out.println("7. Back to Main Menu");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    app.createFlightSchedule();
                    break;
                case 2:
                    System.out.println("\nCreate new flight...");
                    System.out.print("Enter flight ID: ");
                    String flightID = sc.nextLine();
                    System.out.print("Enter origin: ");
                    String origin = sc.nextLine();
                    System.out.print("Enter destination: ");
                    String destination = sc.nextLine();
                    System.out.print("Enter departure time: ");
                    String departureTime = sc.nextLine();
                    System.out.print("Enter gate: ");
                    String gate = sc.nextLine();
                    System.out.print("Enter arrival time: ");
                    String arrivalTime = sc.nextLine();

                    Flight newFlight = new Flight(flightID, origin, destination, departureTime, gate, arrivalTime);
                    app.getFlightManager().addFlight(newFlight);
                    System.out.println("Flight added successfully!");
                    break;
                case 3:
                    System.out.print("Enter the ID of the flight to remove: ");
                    String removeFlightID = sc.nextLine();
                    Flight toRemove = null;
                    for (Flight f : app.getFlightManager().flightList()) {
                        if (f.getFlightID().equalsIgnoreCase(removeFlightID)) {
                            toRemove = f;
                            break;
                        }
                    }
                    if (toRemove != null) {
                        app.getFlightManager().removeFlight(toRemove);
                        System.out.println("Flight removed successfully.");
                    } else {
                        System.out.println("Flight not found.");
                    }
                    break;
                case 4:
                    System.out.println("\nAll Passengers:");
                    for (String p : app.getFlightManager().getPassengerList()) {
                        System.out.println("- " + p);
                    }
                    break;
                case 5:
                    System.out.println("\nAll Staff:");
                    for (String s : app.getFlightManager().getStaffList()) {
                        System.out.println("- " + s);
                    }
                    break;
                case 6:
                    System.out.print("Enter the Flight ID to assign staff to: ");
                    String assignFlightID = sc.nextLine();
                    System.out.print("Enter staff name to assign: ");
                    String staffName = sc.nextLine();
                    System.out.print("Enter staff department: ");
                    String staffDepartment = sc.nextLine();

                    for (Flight f : app.getFlightManager().flightList()) {
                        if (f.getFlightID().equalsIgnoreCase(assignFlightID)) {
                            System.out.println("You chose " + f.toString() + "...");
                            for (Staff s : app.getUserLog().getStaffLog()) {
                                if (s.getName().equalsIgnoreCase(staffName) && s.getDepartment().equalsIgnoreCase(staffDepartment)) {
                                    System.out.println("Assigning " + staffName + " to flight " + assignFlightID + "...");
                                    app.getFlightManager().addStaffToFlight(f, s);
                                    System.out.println("Staff assigned successfully!");
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case 7:
                    System.out.println("Returning to Main Menu...\n");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
                    break;
            }
        } while (true);
    }

    public void showPaymentProcessorMenu() {
        do {
            System.out.println("\nPayment Processor Menu:");
            System.out.println("1. View Transactions");
            System.out.println("2. Back to Main Menu");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Viewing transactions...");
                    for (Payment payment : app.getPaymentProcessor().getPaymentList()) {
                        System.out.println("- " + payment.toString());
                    }
                    break;
                case 2:
                    System.out.println("Returning to Main Menu...\n");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
                    break;
            }
        } while (true);
    }

     public void showTicketManagerMenu() {
        do {
            System.out.println("\nTicket Manager Menu:");
            System.out.println("1. View all Ticket Types");
            System.out.println("2. Update Ticket Prices");
            System.out.println("3. Create New Ticket Type");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Viewing all ticket types...");
                    for (Ticket t : app.getTicketManager().getTicketTypes()) {
                        System.out.println(t.toString());
                    }
                    break;
                case 2:
                    System.out.print("Enter ticket type to update: ");
                    String ticketType = sc.nextLine();
                    System.out.print("Enter new price: ");
                    double newPrice = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("Updating ticket prices...");
                    for (Ticket t : app.getTicketManager().getTicketTypes()) {
                        if (t.getClassType().equalsIgnoreCase(ticketType)) {
                            t.setPrice(newPrice);
                            System.out.println("Updated price for " + ticketType + " tickets to $" + newPrice);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter new ticket ID: ");
                    String newTicketID = sc.nextLine();
                    System.out.print("Enter new ticket type: ");
                    String newTicketType = sc.nextLine();
                    System.out.print("Enter price for " + newTicketType + ": ");
                    double newTicketPrice = sc.nextDouble();
                    sc.nextLine();
                    Ticket newTicket = new Ticket(newTicketType, newTicketID, "N/A", newTicketPrice);
                    app.getTicketManager().addTicketType(newTicket);
                    System.out.println("New ticket type created successfully!\n");
                    break;
                case 4:
                    System.out.println("Returning to Main Menu...\n");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
                    break;
            }
        } while (true);
    }

    public void hrLogIn() {
        System.out.println("\nHuman Resources Login:");
        System.out.println("1. Log in");
        System.out.println("2. Back to Main Menu");
        System.out.print("Choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                String nameLogin;
                int staffIDLogin;

                System.out.print("Enter your name: ");
                nameLogin = sc.nextLine();
                System.out.print("Enter your Staff ID: ");
                staffIDLogin = sc.nextInt();
                sc.nextLine();

                if (nameLogin.equalsIgnoreCase("Jane Smith") && staffIDLogin == 1000) {
                    System.out.println("Login successful! Welcome back, " + nameLogin + "!\n");
                    showHRMenu();
                    return;
                }
                System.out.println("Invalid credentials. Please try again.\n");
                break;
            case 2:
                System.out.println("Returning to Main Menu...\n");
                return;
            default:
                System.out.println("Invalid choice. Please try again.\n");
                break;
        }
    }

    public void showHRMenu() {
        do {
            System.out.println("\nHuman Resources Menu:");
            System.out.println("1. View Employee Records");
            System.out.println("2. Update Employee Information");
            System.out.println("3. Hire New Employee");
            System.out.println("4. Fire Employee");
            System.out.println("5. View TSA Details");
            System.out.println("6. Back to Main Menu");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Viewing employee records...");
                        for (Staff s : app.getUserLog().getStaffLog()) {
                            System.out.println("---------------------------------------------------------------------------------------");
                            System.out.println("- " + s.getName() + " (ID: " + s.getStaffID() + ", Department: " + s.getDepartment() + ", Salary: $" + s.getSalary() + ")");
                        }
                    break;
                case 2:
                    //Case added to update Employee info
                    System.out.print("Enter the ID of the Employee: ");
                    int Id = sc.nextInt();
                    sc.nextLine();

                    for (Staff s : app.getUserLog().getStaffLog()) {
                        if (Id == s.getStaffID()) {
                            System.out.print("What do you Wish to Update? ");
                            String toUpdate = sc.nextLine();
                            if (toUpdate.equalsIgnoreCase("name")) {
                                System.out.print("Enter New Name: ");
                                String name = sc.nextLine();
                                s.setName(name);
                                System.out.println("Information updated successfully!");
                            }
                            else if (toUpdate.equalsIgnoreCase("age")) {
                                System.out.print("Enter New Age: ");
                                int age = sc.nextInt();
                                s.setAge(age);
                                System.out.println("Information updated successfully!");
                            } else if (toUpdate.equalsIgnoreCase("email")) {
                                System.out.print("Enter New Email: ");
                                String email = sc.nextLine();
                                s.setEmail(email);
                                System.out.println("Information updated successfully!");
                            } else if (toUpdate.equalsIgnoreCase("work number")) {
                                System.out.print("Enter New Work Number: ");
                                String workNum = sc.nextLine();
                                s.setWorkNum(workNum);
                                System.out.println("Information updated successfully!");
                            } else if (toUpdate.equalsIgnoreCase("department")) {
                                System.out.print("Enter New Department: ");
                                String department = sc.nextLine();
                                s.setDepartment(department);
                                System.out.println("Information updated successfully!");
                            } else if (toUpdate.equalsIgnoreCase("salary")) {
                                System.out.print("Enter New Salary: ");
                                int salary = sc.nextInt();
                                s.setSalary(salary);
                                System.out.println("Information updated successfully!");
                            }
                        }
                    }
                    break;
                case 3:
                    showHireMenu();
                    break;
                case 4:
                    showFireMenu();
                    break;
                case 5:
                    System.out.println("Viewing TSA details...");
                    System.out.println(app.getTsa().toString());
                    break;
                case 6:
                    System.out.println("Returning to Main Menu...\n");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
                    break;
            }
        } while(true);
    }

    public void showHireMenu() {
        System.out.println("\nHire Menu:");
        System.out.println("1. Hire Aircraft Manager");
        System.out.println("2. Hire Flight Manager");
        System.out.println("3. Hire Payment Processor");
        System.out.println("4. Hire Ticket Manager");
        System.out.println("5. Hire General Staff");
        System.out.println("6. Back to Main Menu");
        System.out.print("Choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter name of new employee: ");
                String newName = sc.nextLine();
                System.out.print("Enter age of new employee: ");
                int newAge = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Staff ID for new employee: ");
                int newStaffID = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter email for new employee: ");
                String newEmail = sc.nextLine();
                System.out.print("Enter work number for new employee: ");
                String newWorkNumber = sc.nextLine();
                System.out.print("Enter salary for new employee: ");
                int newSalary = sc.nextInt();
                sc.nextLine();

                app.getHumanResources().hireAircraftManager(newName, newAge, newStaffID, newEmail, newWorkNumber, newSalary);
                app.getUserLog().addStaff(new AircraftManager(newName, newAge, newStaffID, newEmail, newWorkNumber, "Aircraft Management", newSalary));
                break;
            case 2:
                System.out.print("Enter name of new employee: ");
                String fmName = sc.nextLine();
                System.out.print("Enter age of new employee: ");
                int fmAge = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Staff ID for new employee: ");
                int fmStaffID = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter email for new employee: ");
                String fmEmail = sc.nextLine();
                System.out.print("Enter work number for new employee: ");
                String fmWorkNumber = sc.nextLine();
                System.out.print("Enter salary for new employee: ");
                int fmSalary = sc.nextInt();
                sc.nextLine();

                app.getHumanResources().hireFlightManager(fmName, fmAge, fmStaffID, fmEmail, fmWorkNumber, fmSalary);
                app.getUserLog().addStaff(new FlightManager(fmName, fmAge, fmStaffID, fmEmail, fmWorkNumber, "Flight Management", fmSalary));
                break;
            case 3:
                System.out.print("Enter name of new employee: ");
                String ppName = sc.nextLine();
                System.out.print("Enter age of new employee: ");
                int ppAge = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Staff ID for new employee: ");
                int ppStaffID = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter email for new employee: ");
                String ppEmail = sc.nextLine();
                System.out.print("Enter work number for new employee: ");
                String ppWorkNumber = sc.nextLine();
                System.out.print("Enter salary for new employee: ");
                int ppSalary = sc.nextInt();
                sc.nextLine();

                app.getHumanResources().hirePaymentProcessor(ppName, ppAge, ppStaffID, ppEmail, ppWorkNumber, ppSalary);
                app.getUserLog().addStaff(new PaymentProcessor(ppName, ppAge, ppStaffID, ppEmail, ppWorkNumber, "Payment Processing", ppSalary));
                break;
            case 4:
                System.out.print("Enter name of new employee: ");
                String tmName = sc.nextLine();
                System.out.print("Enter age of new employee: ");
                int tmAge = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Staff ID for new employee: ");
                int tmStaffID = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter email for new employee: ");
                String tmEmail = sc.nextLine();
                System.out.print("Enter work number for new employee: ");
                String tmWorkNumber = sc.nextLine();
                System.out.print("Enter salary for new employee: ");
                int tmSalary = sc.nextInt();
                sc.nextLine();

                app.getHumanResources().hireTicketManager(tmName, tmAge, tmStaffID, tmEmail, tmWorkNumber, tmSalary);
                app.getUserLog().addStaff(new TicketManager(tmName, tmAge, tmStaffID, tmEmail, tmWorkNumber, "Ticket Management", tmSalary));
                break;
            case 5:
                System.out.print("Enter name of new employee: ");
                String gsName = sc.nextLine();
                System.out.print("Enter age of new employee: ");
                int gsAge = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Staff ID for new employee: ");
                int gsStaffID = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter email for new employee: ");
                String gsEmail = sc.nextLine();
                System.out.print("Enter work number for new employee: ");
                String gsWorkNumber = sc.nextLine();
                System.out.print("Enter salary for new employee: ");
                int gsSalary = sc.nextInt();
                sc.nextLine();

                app.getHumanResources().hireGeneralStaff(gsName, gsAge, gsStaffID, gsEmail, gsWorkNumber, gsSalary);
                app.getUserLog().addStaff(new Staff(gsName, gsAge, gsStaffID, gsEmail, gsWorkNumber, "General Staff", gsSalary));
                break;
            case 6:
                System.out.println("Returning to Main Menu...\n");
                return;
            default:
                System.out.println("Invalid choice. Please try again.\n");
                break;
        }
    }

    public void showFireMenu() {
        System.out.println("\nFire Menu:");
        System.out.println("1. Fire Employee by Staff ID");
        System.out.println("2. Back to Main Menu");
        System.out.print("Choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter Staff ID of employee to fire: ");
                int staffIDToFire = sc.nextInt();
                sc.nextLine();
                app.getHumanResources().fireStaff(staffIDToFire);
                app.getUserLog().removeStaff(app.getHumanResources().findStaffByID(staffIDToFire, app.getUserLog()));
                break;
            case 2:
                System.out.println("Returning to Main Menu...\n");
                return;
            default:
                System.out.println("Invalid choice. Please try again.\n");
                break;
        }
    }

    public void start(Application app) {
        showMainMenu();
    }
}
