/**
 * Class to represent each daily record of the S&P 500 equities index
 */

public class SP500Record {
    private String date;
    private double open, high, low, close, adjclose;
    private long volume;
    private String note;
    
    /**
     * By default, a S&P 500 index record will not contain any special notes.
     * @param date Date of record observation
     * @param open Opening value 
     * @param high Highest value during the day
     * @param low Lowest value during the day
     * @param close Closing value
     * @param adjclose Adjusted closing value (to account for equity events)
     * @param volume Trading volume during the day
     */
    public SP500Record(String date, double open, double high, 
            double low, double close, double adjclose, long volume) {
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.adjclose = adjclose;
        this.volume = volume;
        this.note = "";
    }

    public String getDate() {       
        return this.date;
    }
        
    public double getOpen() {
        return this.open;
    }
    
    public double getHigh() {
        return this.high;
    }
    
    public double getLow() {
        return this.low;
    }
    
    public double getClose() {
        return this.close;
    }
    
    public double getAdjclose() {
        return this.adjclose;
    }
    
    public long getVolume() {
        return this.volume;
    }
    
    public String getNote() {
        return this.note;
    }
    
    public void setNote(String otherNote) {
        this.note = otherNote;
    }
    
    /**
     * Sets all the fields of a S&P 500 index record.
     */
    public void setRecord(String date, double open, double high, 
            double low, double close, double adjclose, long volume, 
            String note) {
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.adjclose = adjclose;
        this.volume = volume;
        this.note = note;
    }
    
    @Override
    public String toString() {
        String str = String.format("date: %s\topen value: %.2f\tclose value: %.2f",
                this.date, this.open, this.close);
        return str;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (o.getClass() == SP500Record.class) {
            SP500Record other = (SP500Record) o;
            return (other.adjclose == this.adjclose &&
                    other.close == this.close &&
                    other.date.equals(this.date) &&
                    other.high == this.high &&
                    other.low == this.low &&
                    other.note.equals(this.note) &&
                    other.open == this.open &&
                    other.volume == this.volume);
        }
        return false;
    }
}