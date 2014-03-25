/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package puissance.x;

/**
 *
 * @author Alexandre MIRABEL
 */
import java.util.*;
public class PuissanceX {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int nbColonne=7;
        int nbLigne=6;
        boolean jouer=true;
        int[][] laGrille= new int[7][6];
        Scanner sc= new Scanner(System.in);
        for(int i=0;i<laGrille.length;i++)
        {
            for(int j=0;j<laGrille[i].length;j++)
            {
                laGrille[i][j]=0;
            }
            
        }
        
        int joueur=1;
        
        while(jouer)
        {
            AfficherLaGrille(laGrille);

            boolean chiffrePasOk=true;
            int laColonne=-1;
            while(chiffrePasOk)
            {
                try{
                    System.out.println("Au joueur "+joueur+" de jouer, sur quelle colonne voulez vous insérer un jeton ?");
                    laColonne=sc.nextInt();
                    chiffrePasOk=false;
                }catch(Exception e)
                {
                    System.out.println("Vous n'avez pas rentré un chiffre... :'(");
                    sc.nextLine();
                }
            }
            
            String affectJeton=AffecterUnJeton(joueur,laColonne,laGrille);
            if(affectJeton!=null)
            {
                System.out.println(affectJeton);
                  
            }
            else
            {
                
                if(TesterGagner(joueur,laGrille)==1)
                {
                    System.out.println("Le joueur "+joueur+" à gagner ! ");
                    break;
                }  
                else if(TesterGagner(joueur,laGrille)==2)
                {
                   

                    System.out.println("Egalité  : ");
                     AfficherLaGrille(laGrille);
                    break;
                }
                if(joueur==1)
                {
                    joueur=2;
                }
                else
                {
                    joueur=1;
                }
            }

            
            
          
        }
        

    }
    
    public static int[][] AfficherLaGrille(int[][] LaGrille)
    {
        for(int i=0;i<LaGrille.length;i++)
        {
            for(int j=0;j<LaGrille[i].length;j++)
            {
                System.out.print(LaGrille[i][j]+"  ");
            }
            System.out.print("\r\n");
        }
        
        return LaGrille;
    }
    
    public static String AffecterUnJeton(int nbJoueur,int col, int[][] laGrille)
    {
        String message_retour=null;
       if(col>laGrille.length || col<1)
       {
           message_retour="La colonne est hors limite... ";
       }
       else if(laGrille[0][col-1]!=0)
       {
           message_retour="La colonne est pleine ";
       }
       else
       {
            col=col-1;
            int j=laGrille.length-1;
            while(laGrille[j][col]>0)
            {
                j--;
            }
            laGrille[j][col]=nbJoueur;
        
       }
       
       return message_retour;
    }
    
    public static int TesterGagner(int nbJoueur, int[][] laGrille)
    {
        boolean pasGagner=true;
        int total=0;
        int i=0;

        //Horizontal
        while(i<laGrille.length && pasGagner)
        {
            for(int j=0;j<laGrille[i].length;j++)
            {
                if(laGrille[i][j]==nbJoueur)
                {
                    total++;
                    if(total>=4)
                    {pasGagner=false;}
                }
                else
                {total=0;}
            }
           
            i++;
            total=0;
        }
        
        //Vertical
        i=0;
        total=0;
        while(i<laGrille[0].length && pasGagner)
        {
            for(int j=0;j<laGrille.length;j++)
            {
                if(laGrille[j][i]==nbJoueur)
                {
                    total++;
                    if(total>=4)
                    {pasGagner=false;}
                }
                else
                {total=0;}
            }
           
            i++;
            total=0;
        }
        i=0;
        boolean pasEgalite=true;
        //Egalité
        while(i<laGrille[0].length && pasEgalite)
        {
            if(laGrille[0][i]==0)
            {
                pasEgalite=false;
            }
            i++;
        }
        int retour=0;
        if(!pasGagner)
        {
            retour=1;
        }
        if(pasEgalite)
        {
            retour=2;
        }
        
        return retour;
    }
    
}
