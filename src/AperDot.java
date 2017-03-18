import Lib.Complex;

/**
 * Created by L i o n on 3/18/2017.
 * Seyed Iman Hosseini Zavaraki
 * Github @ https://github.com/ImanHosseini
 * Wordpress @ https://imanhosseini.wordpress.com/
 */
public class AperDot {
    public static double k=2.0*Math.PI/(0.00000004);                // 2PI/lambda _ lambda is the wavelenght
    public double[] pos;                                            // X_Y_Z
    public Diffraction df;
//    public AperDot(double[] pos){
//        this.pos=pos;
//    }
    public AperDot(double x, double y, double z,Diffraction df){
        this.pos=new double[3];
        pos[0]=x;
        pos[1]=y;
        pos[2]=z;
        this.df=df;
    }
//    public void emit(ScreenDot sd){
//        double r=Math.pow((this.pos[0]-sd.pos[0]),2.0)+Math.pow((this.pos[1]-sd.pos[1]),2.0)+Math.pow((this.pos[2]-sd.pos[2]),2.0);
//        r=Math.sqrt(r);
//        double re=Math.cos(k*r)/r;
//        double img=Math.sin(k*r)/r;
//        System.out.println("RE "+re+" IMG "+img);
//        sd.Efield.plus(new Complex(re,img));
//    }
    public void emit(){
        for(ScreenDot sd : df.screen){
            double r=Math.pow((this.pos[0]-sd.pos[0]),2.0)+Math.pow((this.pos[1]-sd.pos[1]),2.0)+Math.pow((this.pos[2]-sd.pos[2]),2.0);
            r=Math.sqrt(r);
            double re=Math.cos(k*r)/r;
            double img=Math.sin(k*r)/r;
            //System.out.println("RE "+re+" IMG "+img);
            sd.Efield=sd.Efield.plus(new Complex(re,img));
        }
        }
    }

