package nao.cycledev.carols.model;

public class Carol {

    private long id;
    private String title;
    private String text;
    private String info;

    public Carol(long id, String title, String text, String info) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.info = info;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
