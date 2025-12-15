## 📊 Database Design

The application uses a relational database with four core entities:
Customer, Driver, Cab, and Booking.

### 🔗 Entity Relationships
- One Customer can create multiple Bookings
- One Driver can handle multiple Bookings
- Each Driver is associated with one Cab

### 🧩 ER Diagram

    CUSTOMER {
        int customerId
        string name
        int age
        string emailId
        string gender
    }

    DRIVER {
        int driverId
        string name
        int age
        string emailId
    }

    CAB {
        int cabId
        string cabNumber
        string cabModel
        double perKmRate
        boolean available
    }

    BOOKING {
        int bookingId
        string pickup
        string destination
        double tripDistanceInKm
        string tripStatus
        double billAmount
        date bookedAt
        date lastUpdateAt
    }

    

