/**
 * Created by berg on 25/01/17.
 */
public class Page {
    private int nProcess;
    private int nPage;
    private int bit;

    public Page(int nProcess, int nPage) {
        this.nProcess = nProcess;
        this.nPage = nPage;
    }

    public Page(int nProcess, int nPage, int bit) {
        this.nProcess = nProcess;
        this.nPage = nPage;
        this.bit = bit;
    }

    public int getnProcess() {
        return nProcess;
    }

    public void setnProcess(int nProcess) {
        this.nProcess = nProcess;
    }

    public int getnPage() {
        return nPage;
    }

    public void setnPage(int nPage) {
        this.nPage = nPage;
    }

    public String toString() {
        return nProcess + " " + nPage;
    }

    public int getBit() {
        return bit;
    }

    public void setBit(int bit) {
        this.bit = bit;
    }
}
