import java.util.*;

public class FinalCal {
    
    public double calc(ArrayList<String> equa) {
        if(equa.contains("(") || equa.contains(")"))
        {
            int leftP = 0;
            int rightP = 0;
            boolean first = false;
            ArrayList<String> temp = new ArrayList<String>();
            for(int i = 0; i < equa.size(); i ++)
            {
                if(equa.get(i).equals("(") && first == false)
                {
                    leftP = i;
                    first = true;
                }
                else if(equa.get(i).equals(")"))
                {
                    rightP = i;
                }
            }
            int index = leftP+1;
            for(int i = index; i < rightP; i++)
            {
                temp.add(equa.get(i));
            }
            equa.set(leftP, ""+calc(temp));
            for(int i =index; i <= rightP; i++)
            {
                
                equa.remove(index);
            }
        }
        while(equa.contains("^"))
        {
            double sum = 0;
            int powIndex = equa.indexOf("^");
            sum = power(Double.parseDouble(equa.get(equa.indexOf("^")-1)), Double.parseDouble(equa.get(equa.indexOf("^")+1)));
            equa.remove(equa.indexOf("^")-1);
            equa.remove(equa.indexOf("^")+1);
            equa.set(equa.indexOf("^"), Double.toString(sum));
        }
        while(equa.contains("*") || equa.contains("/"))
        {
            double sum = 0;
            int multIndex = equa.indexOf("*");
            int divIndex = equa.indexOf("/");
            if(multIndex < divIndex)
            {
                if (multIndex == -1)
                {
                    sum = div(Double.parseDouble(equa.get(equa.indexOf("/")-1)), Double.parseDouble(equa.get(equa.indexOf("/")+1)));
                    equa.remove(equa.indexOf("/")-1);
                    equa.remove(equa.indexOf("/")+1);
                    equa.set(equa.indexOf("/"), Double.toString(sum));
                }
                else
                {
                    sum = mult(Double.parseDouble(equa.get(equa.indexOf("*")-1)), Double.parseDouble(equa.get(equa.indexOf("*")+1)));
                    equa.remove(equa.indexOf("*")-1);
                    equa.remove(equa.indexOf("*")+1);
                    equa.set(equa.indexOf("*"), Double.toString(sum));

                }
            }
            if(divIndex < multIndex){
                if (divIndex == -1)
                {
                    sum = mult(Double.parseDouble(equa.get(equa.indexOf("*")-1)), Double.parseDouble(equa.get(equa.indexOf("*")+1)));
                    equa.remove(equa.indexOf("*")-1);
                    equa.remove(equa.indexOf("*")+1);
                    equa.set(equa.indexOf("*"), Double.toString(sum));

                }
                else
                {
                    sum = div(Double.parseDouble(equa.get(equa.indexOf("/")-1)), Double.parseDouble(equa.get(equa.indexOf("/")+1)));
                    equa.remove(equa.indexOf("/")-1);
                    equa.remove(equa.indexOf("/")+1);
                    equa.set(equa.indexOf("/"), Double.toString(sum));
                }
            }

        }

        // while(equa.contains("/"))
        // {
        //     double sum = 0;
        //     int divIndex = equa.indexOf("/");
        //     sum = div(Double.parseDouble(equa.get(divIndex-1)), Double.parseDouble(equa.get(divIndex+1)));
        //     equa.remove(equa.get(equa.indexOf("*")-1));
        //     equa.remove(equa.get(divIndex));
        //     equa.set(equa.indexOf("/"), Double.toString(sum));
        // }
        while(equa.contains("+"))
        {
            double sum = 0;

            sum = plus(Double.parseDouble(equa.get(equa.indexOf("+")-1)), Double.parseDouble(equa.get(equa.indexOf("+")+1)));
            equa.remove(equa.indexOf("+")-1);
            equa.remove(equa.indexOf("+")+1);
            equa.set(equa.indexOf("+"), Double.toString(sum));

        }
        while(equa.contains("-"))
        {
            double sum = 0;
            int subIndex = equa.indexOf("-");
            sum = sub(Double.parseDouble(equa.get(equa.indexOf("-")-1)), Double.parseDouble(equa.get(equa.indexOf("-")+1)));
            equa.remove(equa.indexOf("-")-1);
            equa.remove(equa.indexOf("-")+1);
            equa.set(equa.indexOf("-"), Double.toString(sum));
        }

        return Double.parseDouble(equa.get(0));
    }

    public double plus(double num1, double num2) {
        double result = num1+num2;
        return result;
    }
    public double sub(double num1, double num2){
        double result = num1-num2;
        return result;
    }
    public double div(double num1, double num2)
    {
        double result = num1 / num2;
        return result;
    }
    public double mult(double num1, double num2)
    {
        double result = num1 * num2;
        return result;
    }
    public double power(double num1, double num2)
    {
        double result = Math.pow(num1, num2);
        return result;
    }

}
