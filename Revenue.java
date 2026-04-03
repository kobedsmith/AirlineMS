//Kobe Smith on 3/31/2026

public class Revenue {
    private double econRevenue;
    private double premRevenue;
    private double busRevenue;
    private double firstRevenue;

    public Revenue(double econRevenue, double premRevenue, double busRevenue, double firstRevenue) {
        this.econRevenue = econRevenue;
        this.premRevenue = premRevenue;
        this.busRevenue = busRevenue;
        this.firstRevenue = firstRevenue;
    }

    public double getEconRevenue() {
        for (Ticket ticket : econTickets) {
            econRevenue += ticket.getEconPrice(econTickets);
        }
        return econRevenue;
    }

    public double getPremRevenue() {
        for (Ticket ticket : premTickets) {
            premRevenue += ticket.getPremPrice(premTickets);
        }
        return premRevenue;
    }

    public double getBusRevenue() {
        for (Ticket ticket : busTickets) {
            busRevenue += ticket.getBusPrice(busTickets);
        }
        return busRevenue;
    }

    public double getFirstRevenue() {
        for (Ticket ticket : firstTickets) {
            firstRevenue += ticket.getFirstPrice(firstTickets);
        }
        return firstRevenue;
    }
}