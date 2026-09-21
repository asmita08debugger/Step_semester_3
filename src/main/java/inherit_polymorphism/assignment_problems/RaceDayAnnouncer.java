package main.java.inherit_polymorphism.assignment_problems;
public class RaceDayAnnouncer 
{
    static class RaceEntry 
    {
        protected String bibNumber;
        protected double balanceDue;
        public RaceEntry(String bibNumber, double balanceDue) 
        {
            this.bibNumber = bibNumber;
            this.balanceDue = balanceDue;
        }
        public void announce() 
        {
            System.out.println("Race Entry | Bib: " + bibNumber + " | Balance: " + balanceDue);
        }
    }
    static class RunnerEntry extends RaceEntry 
    {
        private String category;
        public RunnerEntry(String bibNumber, double balanceDue, String category) 
        {
            super(bibNumber, balanceDue);
            this.category = category;
        }
        @Override
        public void announce() 
        {
            System.out.println("Runner Entry | Bib: " + bibNumber + " | Category: " + category + " | Balance: " + balanceDue);
        }
    }
    static class RelayTeamEntry extends RaceEntry 
    {
        private int teamSize;
        public RelayTeamEntry(String bibNumber, double balanceDue, int teamSize) 
        {
            super(bibNumber, balanceDue);
            this.teamSize = teamSize;
        }
        @Override
        public void announce() 
        {
            System.out.println("Relay Team | Bib: " + bibNumber + " | Team Size: " + teamSize + " | Balance: " + balanceDue);
        }
        public int getTeamSize() 
        {
            return teamSize;
        }
    }
    static String announceAll(RaceEntry[] entries) 
    {
        StringBuilder report = new StringBuilder();
        for (RaceEntry entry : entries) 
        {
            entry.announce();
            report.append("Announced: ")
                  .append(entry.bibNumber);
            if (entry instanceof RelayTeamEntry) 
            {
                RelayTeamEntry relay = (RelayTeamEntry) entry;
                report.append(" | Relay team size: ")
                      .append(relay.getTeamSize());
            }
            report.append("\n");
        }
        return report.toString();
    }
    public static void main(String[] args) 
    {
        RaceEntry runner = new RunnerEntry("BIB2001", 80, "Open 10K");
        RaceEntry relay = new RelayTeamEntry("BIB4001", 300, 4);
        RaceEntry[] entries = {runner, relay};
        System.out.println(announceAll(entries));
    }
}