import java.util.Random;
import java.util.Scanner;
public class The_Elder{
    public static void main(String[] args) {

                System.out.println("WARNING THIS CODE IS VERY OLD AND ONLY USED FOR RECREATIONAL PURPOSES");

                Scanner sc= new Scanner(System.in);

                System.out.println("Pick a number between 1-10 to choose how your story goes");

                System.out.println();

                int number =sc.nextInt(  );

                System.out.println("You picked "+number+" is this okay?");

                String answer= sc.next();

                Random randomNumber = new Random();

                int winningNum = randomNumber.nextInt(10)+1;

                String no= "no";

                System.out.println(+winningNum);

                if (+winningNum == number) {

                    System.out.println("You've won the lottery lets see your outcome;");

                    System.out.println("As you acquire the direct deposit half of the money has been taxed");

                    System.out.println("With the $$$ you've earned you begin to make ridiculous purchase's with the money");

                    System.out.println("You purchased a(n) million dollar mansion and a Acura for whatever reason,");

                    System.out.println("Over the next few years your bank account has run dry causing you to have to sell everything you own");

                    System.out.println("After selling everything you own it's still not enough money to afford bills");

                    System.out.println("You end up becoming homeless and broke you live the rest of your life out on the streets~The end");

                } else{

                    System.out.println("You are sad about not winning the lottery but you carry on with your life.");

                    System.out.println("As you wake up one morning for work at your boring 9-5 job you realize you're running 15 minuets late");

                    System.out.println("As you are rushing out the door and onto your bike the owner of a very well renowned company,");

                    System.out.println("hits you with his motorcycle and knocks you off of your bike and feels terrible about it");

                    System.out.println("He offers you a job position offering almost double what you currently make. ");

                    System.out.println("Will you accept this position?");

                    String job =sc.next(  );

                    if(job.equals(no)) {

                        System.out.println("You carry on living your boring 9-5 and barely making living wage~The End ");

                    } else{

                        System.out.println("As you work with the company longer you have risen the ranks ");

                        System.out.println("The owner of the company has fallen ill with a terminal disease ");

                        System.out.println("on his deathbed the owner offers you the company you have a choice of either accepting the company or not ");

                        System.out.println("Will you accept the company?");

                        String company = sc.next();

                        if (company.equals(no)){

                            System.out.println("The company is handed to the owners children and they don't know how to run a business and they end up");

                            System.out.println ("selling the company for a very small amount and the company falls because of the new owner~Fin");

                        }else{

                            System.out.println("You gratefully accept the company at this point in life you are a successful business owner");

                            System.out.println("your making nearly 6 times the amount you were making after you woke up 15 minuets late");

                            System.out.println("Because of this you start donating 20% of all profits made from the business to charity and the under privileged");

                            System.out.println("At this point You have 3 children name them");

                            System.out.println("Name Your Daughter");

                            String child1= sc.next();

                            System.out.println("Name Your Son");

                            String child2=sc.next();

                            System.out.println("Name your newborn son");

                            String child3=sc.next();

                            System.out.println(child1+" Is a world famous actor");

                            System.out.println(child2+" Is a well known game designer");

                            System.out.println(child3+" Grew up to be a public speaker");

                            int Disaster= randomNumber.nextInt(2);

                            if (Disaster==1){

                                System.out.println("You and your family were murdered in a home invasion");

                            }else{

                                System.out.println(child1+" Was found dead in her home");

                                System.out.println("You have broken down and taken 5 years off of your life");

                                System.out.println("Your remaining life is 10 years left");

                                int carcrash= randomNumber.nextInt(2);

                                if (carcrash==1){

                                    System.out.println("You and the rest of your family were killed in a 4-way car crash");

                                }else {

                                    System.out.println("You lived the rest of your life normally and died by natural causes");

                                }

                            }
                        }

                    }

                }

            }

        }
