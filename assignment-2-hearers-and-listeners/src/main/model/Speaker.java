package model;

public interface Speaker{
    public void say(String s, Hearer h);
    public boolean didISay(String s);
}
