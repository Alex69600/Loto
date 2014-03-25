using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Loto
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] tabLoto= new int[6];
		    Random r=new Random();
		    DateTime date = DateTime.Now;
		
		


		Console.WriteLine("--------------------------------------------- \n");
		Console.Write("\n *    ****         *    **** ***** ****");
		Console.Write("\n *    ***          *    *  *   *   *  *");
		Console.Write("\n **** ****         **** ****   *   ****");
		Console.Write("\n tirage du "+ date.Day +"/"+ date.Month +"/"+ date.Year +" a "+ date.Hour +"h"+ date.Minute);


		for (int i=0;i<6;i++)
		{
			tabLoto[i]=Math.Abs(r.Next(50));
		}

		Console.Write("\n Les 6 chiffres du loto dans l'ordre du tirage");

		for(int i=0;i<6;i++)
		{
			Console.Write("\n    "+tabLoto[i]);
		}

        Array.Sort(tabLoto);
		Console.Write("\n Les 6 chiffres tries");

		for(int i=0;i<6;i++)
		{
			Console.Write("\n    "+tabLoto[i]);
		}

		Console.Write("\n ---------------------------------------------");
        Console.ReadLine();
        }
      
    }
}
