package air.template;

public interface Template {
    public void setVariable(String name, Object obj);
    public String toHTML();
}
