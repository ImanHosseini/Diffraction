import Lib.Complex;
import Lib.Picture;

import java.awt.*;


/**
 * Created by L i o n on 3/18/2017.
 * Seyed Iman Hosseini Zavaraki
 * Github @ https://github.com/ImanHosseini
 * Wordpress @ https://imanhosseini.wordpress.com/
 */
public class Diffraction {
    public static double H_DEFAULT=10.0;                     //Distance to screen
    public static double La_DEFAULT=0.001;                  //Length of aperture
    public static double Ls_DEFAULT=0.003;                   //Length of screen
    public static int NScreen_DEFAULT=100*100;                 //Points on screen (must be squared)
    public static int Nap_DEFAULT=20*20;                      //Points on aperture (must be squared)
    public double H,La,Ls;
    public int NScreen,Nap;
    public ScreenDot[] screen;
    public AperDot[] aperture;
    public Diffraction(){
        this.H=H_DEFAULT;
        this.La=La_DEFAULT;
        this.Ls=Ls_DEFAULT;
        this.NScreen=NScreen_DEFAULT;
        this.Nap=Nap_DEFAULT;
    }
    public Diffraction(double H, double La, double Ls, int NScreen, int Nap){
        this.H=H;
        this.La=La;
        this.Ls=Ls;
        this.NScreen=NScreen;
        this.Nap=Nap;
    }
    public void diffract(){
        screen=new ScreenDot[NScreen];
        aperture=new AperDot[Nap];
        int NsSqr=(int)Math.sqrt((double)NScreen);
        double x_i=-Ls/2.0;
        double y_i=-Ls/2.0;
        double dx=Ls/NsSqr;
        int t=0;
            for(int i=0;i<NsSqr;i++){
                for(int j=0;j<NsSqr;j++){
                screen[t]=new ScreenDot(x_i+((double)i)*dx,y_i+((double)j)*dx,H);
                        t++;
                }
            }
        t=0;
        NsSqr=(int)Math.sqrt((double)Nap);
        dx=La/NsSqr;
         x_i=-La/2.0;
         y_i=-La/2.0;
        for(int i=0;i<NsSqr;i++){
            for(int j=0;j<NsSqr;j++){
                aperture[t]=new AperDot(x_i+((double)i)*dx,y_i+((double)j)*dx,0.0,this);
                t++;
            }
        }
        for(AperDot ap:aperture){

                ap.emit();

        }
        NsSqr=(int)Math.sqrt((double)NScreen);
        Picture p=new Picture(NsSqr,NsSqr);
        t=0;
        double maxval=0.0;
        double[][] clrs=new double[NsSqr][NsSqr];
        for(t=0;t<screen.length;t++){
            double val=screen[t].getIntensity();
            int x=t/NsSqr;
            int y=t%NsSqr;
            clrs[x][y]=val;
            if(val>maxval){
                maxval=val;
            }
        }
        for(int ix=0;ix<NsSqr;ix++){
            for(int iy=0;iy<NsSqr;iy++){
                System.out.println(clrs[ix][iy]);
                p.set(ix,iy,new Color((float)(clrs[ix][iy]/maxval),(float)0.0,(float)0.0));
            }
        }
        p.show();
    }
    public static void main(String[] args){
        Diffraction df=new Diffraction();
        df.diffract();
    }
}
