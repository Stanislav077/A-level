/**
 * Created by Станислав on 23.05.2018.
 */
public class Extra implements Lable {
    protected Lable lable;
    protected String labels;


    public Extra(String labels, Lable lable) {

        this.labels = labels;
        this.lable = lable;

    }

    public String getLabel() {

        return lable.getLabel() + ", " + this.labels;
    }
}
