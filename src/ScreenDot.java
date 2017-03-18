import Lib.Complex;

/**
 * Created by L i o n on 3/18/2017.
 * Seyed Iman Hosseini Zavaraki
 * Github @ https://github.com/ImanHosseini
 * Wordpress @ https://imanhosseini.wordpress.com/
 */
public class ScreenDot {
    public Complex Efield;
    public double[] pos;                    // X_Y_Z
    public ScreenDot(double[] pos){
        this.pos=pos;
        this.Efield=new Complex(0.0,0.0);
    }
    public ScreenDot(double x,double y, double z){
        this.pos=new double[3];
        pos[0]=x;
        pos[1]=y;
        pos[2]=z;
        this.Efield=new Complex(0.0,0.0);
    }
    public double getIntensity(){
        return Efield.abs();
    }
}
