Hier ist ein Beispiel für die Verwendung des Port-Konzepts nach Rupp und des Proxy-Patterns für eine Hotelsuche:

```java
public interface HotelSearchPort {
public void setCity(String city);
public void setDateRange(String startDate, String endDate);
public Hotel[] search();
}

public class HotelRetrieval implements HotelSearchPort {
private String city;
private String startDate;
private String endDate;

    public void setCity(String city) {
        this.city = city;
    }

    public void setDateRange(String startDate, String endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Hotel[] search() {
        // Implementierung der Hotelsuche
        return new Hotel[0];
    }
}

public class HotelSearchPortProxy implements HotelSearchPort {
private HotelRetrieval hotelRetrieval;

    public HotelSearchPortProxy(HotelRetrieval hotelRetrieval) {
        this.hotelRetrieval = hotelRetrieval;
    }

    public void setCity(String city) {
        // Zugriffskontrolle oder zusätzliche Funktionalitäten
        hotelRetrieval.setCity(city);
    }

    public void setDateRange(String startDate, String endDate) {
        // Zugriffskontrolle oder zusätzliche Funktionalitäten
        hotelRetrieval.setDateRange(startDate, endDate);
    }

    public Hotel[] search() {
        // Zugriffskontrolle oder zusätzliche Funktionalitäten
        return hotelRetrieval.search();
    }
}

public class HotelSearchComponent {
private HotelSearchPort hotelSearchPort;

    public HotelSearchComponent(HotelSearchPort hotelSearchPort) {
        this.hotelSearchPort = hotelSearchPort;
    }

    public void execute() {
        // Implementierung der Komponentenlogik
        Hotel[] hotels = hotelSearchPort.search();
        // Verarbeitung der Suchergebnisse
    }
}

public class Main {
public static void main(String[] args) {
HotelRetrieval hotelRetrieval = new HotelRetrieval();
HotelSearchPort hotelSearchPort = new HotelSearchPortProxy(hotelRetrieval);
HotelSearchComponent component = new HotelSearchComponent(hotelSearchPort);

        hotelSearchPort.setCity("Berlin");
        hotelSearchPort.setDateRange("2022-01-01", "2022-01-07");

        component.execute();
    }
}

```
In diesem Beispiel wird das HotelSearchPort-Interface erstellt und von der HotelRetrieval-Klasse implementiert. Die HotelRetrieval-Klasse ist das ursprüngliche Objekt, das die Parameter für die Hotelsuche enthält und die Suche durchführt. Die HotelSearchPortProxy-Klasse implementiert ebenfalls das HotelSearchPort-Interface und dient als Schnittstelle zum HotelRetrieval-Objekt. In den Methoden der HotelSearchPortProxy-Klasse können Zugriffskontrollen oder zusätzliche Funktionalitäten implementiert werden.

Die HotelSearchComponent-Klasse verwendet ein HotelSearchPort-Objekt und implementiert die Logik in der execute-Methode. Im Hauptprogramm wird ein HotelRetrieval-Objekt erstellt und einem HotelSearchPortProxy-Objekt übergeben. Dieses HotelSearchPortProxy-Objekt wird dann einem HotelSearchComponent-Objekt übergeben. Die Parameter für die Hotelsuche werden festgelegt und die execute-Methode der Komponente wird aufgerufen.