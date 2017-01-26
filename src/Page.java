/**
 * Created by berg on 25/01/17.
 */
public class Page {
    private int nProcess;
    private int nPage;

    public Page(int nProcess, int nPage) {
        this.nProcess = nProcess;
        this.nPage = nPage;
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
}
