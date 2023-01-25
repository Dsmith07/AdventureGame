package game;

import java.util.Scanner;
public class The_Self_Proclaimed_Giant {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("The Self Proclaimed Giant\nBy: Benjamin Bowman");
        System.out.println("\nDo you wish to continue");
        String question = scan.next().toLowerCase();
        if (question.equals("y") || question.equals("yes")){
            System.out.print("You are born a dwarf you travel far and wide in hopes someone is shorter than you");
            System.out.print(" with no hope in sight you have 2 options\n1. Give up and except your height." +
                    "\n2. Refuse and live a lie.\n");
            int option1 = scan.nextInt();
            if (option1 == 1){
                System.out.print("By a great surprise you grow to the height of a giant");
                System.out.print(" with that tall person energy radiating off of you a woman approaches you");
                System.out.println("\nWhat do you:\n1. Talk to her.\n2. Scream and smile.");
                int option2A = scan.nextInt();
                if (option2A == 1){
                    System.out.println("You croak out a hello and your name");
                    System.out.println("She responds and say her name is INSERT VERY WOMAN NAME");
                    System.out.println("After some chit chat you ask why she approached you she says because you aren't short");
                    System.out.println("Not being completely use your new height how do you respond");
                    System.out.println("1. Act Cool.\n2. Become greatly upset and offended.");
                    int option3A = scan.nextInt();
                    if (option3A == 1){
                        System.out.println("You act cool about what she said and continue talking");
                        System.out.println("She has to go but gives you her number");
                        System.out.println("Do you\n1. Call her and ask her out.\n2. Get her number on scam call lists.");
                        int option4A = scan.nextInt();
                        if (option4A == 1){
                            System.out.println("You call her and plan a date");
                            System.out.println("You go to a restaurant and keep talking");
                            System.out.println("But you feel off since she mentions how she doesn't like lying even about height");
                            System.out.println("How do you react\n1. Slap her and run out.\n2. Keep talking with her.");
                            int option5A = scan.nextInt();
                            if (option5A == 1) {
                                System.out.println("You hit her with the force of a thousand suns and sprint faster then humanly possibly");
                                System.out.println("You are chased down by the law enforcement and they tell you to give up");
                                System.out.println("What do you do\n1. Keep fighting.\n2. Give up.");
                                int option6A = scan.nextInt();
                                if (option6A == 1){
                                    System.out.println("You fight and you were winning for a period of time");
                                    System.out.println("But you lose swinging and go down for the count");
                                    System.out.println("Ending:\n       The Outlaw");
                                }
                                else {
                                    System.out.println("You get down on the ground and a sometime passes");
                                    System.out.println("You and your case is pending which lawyer do you hire");
                                    System.out.println("1. J.D. Bronner.\n2. Slippin Jimmy.");
                                    int option7A = scan.nextInt();
                                    if (option7A == 1){
                                        System.out.println("You hire Bronner since his name is more normal");
                                        System.out.println("You go to court and your defense was terrible");
                                        System.out.println("A witness reports that out of no where you hit the victim with the force of a thousand suns");
                                        System.out.println("You are found guilty of several counts of attempted murder and charges of assault");
                                        System.out.println("When you arrive to your new home prison what do you do");
                                        System.out.println("1. Rise to be on top.\n2. Live a quietly");
                                        int option8A = scan.nextInt();
                                        if (option8A == 1){
                                            System.out.println("You want to be top dog in this prison world");
                                            System.out.println("You make connections in short time");
                                            System.out.println("After sometime you have 2 ideal options");
                                            System.out.println("1. Challenge the current leader of the gangs.\n2. Continue to gather power and favor.");
                                            int option9A = scan.nextInt();
                                            if (option9A == 1){
                                                System.out.println("You challenge the leader to a fight");
                                                System.out.println("He laughs saying you aren't strong enough to win");
                                                System.out.println("You get surrounded and he charges you");
                                                System.out.println("How do you respond\n1. Jump out of the way and counter.\n2. Challenge the charge.");
                                                int option10A = scan.nextInt();
                                                if (option10A == 1){
                                                    System.out.println("You leap out of the way knowing the charge was a faint");
                                                    System.out.println("You successfully countered and hit him hard");
                                                    System.out.println("He isn't down and he goes for a powerful swing");
                                                    System.out.println("How do you react\n1. Block his attack.\n2. Dodge with your life on the line.");
                                                    int option11A = scan.nextInt();
                                                    if (option11A == 1){
                                                        System.out.println("You blocked his attack and he is left winded");
                                                        System.out.println("You go on the attack and win you beat him down");
                                                        System.out.println("You become the new head of his and the other gangs");
                                                        System.out.println("Ending:\n       El Sin Nombre");
                                                    }
                                                    else {
                                                        System.out.println("You try your best and dodge with your life on your mind");
                                                        System.out.println("You got hit and you are down for the count no getting up");
                                                        System.out.println("Ending:\n       The RKO");
                                                    }
                                                }
                                                else {
                                                    System.out.println("You challenge the charge with your own");
                                                    System.out.println("He pushes you to the ground and bets you until lights out");
                                                    System.out.println("Ending:\n       The Knock Out");
                                                }
                                            }
                                            else {
                                                System.out.println("You continue to gather power and favor");
                                                System.out.println("Your group becomes the most powerful");
                                                System.out.println("You easily take control and live with the power");
                                                System.out.println("Ending:\n       The Top Pug");
                                            }
                                        }
                                        else {
                                            System.out.println("You try to keep your head down and keep to yourself");
                                            System.out.println("You manage to just get by thanks to paying for protection");
                                            System.out.println("And you gain favor with guards by ratting out others");
                                            System.out.println("Ending:\n       Obedient Prisoner");
                                        }
                                    }
                                    else {
                                        AdventureGame.sp.playSound("saul.wav");
                                        System.out.println("You hired Slippin jimmy");
                                        System.out.println("He tells you he is the best around");
                                        System.out.println("During the trial he fights tooth and nail no trick is to much");
                                        System.out.println("He was trying to get you out of the charges");
                                        System.out.println("He does it you are cleared of all charges");
                                        System.out.println("Ending:\n       Better Call Slippin Jimmy");
                                    }
                                }
                            }
                            else {
                                System.out.println("You keep talking leading to");
                                System.out.println("More and more dates and eventually marriage");
                                System.out.println("Do you find yourself happy in this life");
                                System.out.println("1. Yes I am happy.\n2. No.");

                            }
                        }
                        else{
                            System.out.println("You think it was funny but bragging about it lead to you being disliked");
                            System.out.println("No more people and came up to talk to you now you will leave lonely");
                            System.out.println("Ending:\n       Short Lived Compassion");
                        }
                    }
                    else {
                        System.out.println("You scream and yell how it isn't fair to other short people");
                        System.out.println("you bust down into tears and curl up into a ball");
                        System.out.println("Screaming to people to get away the girl runs away calling you a freak");
                        System.out.println("Ending:\n       Short Tempered Freak");
                    }
                }
                else{
                    System.out.println("");
                }
            }
            else{
                System.out.println("To cover for your size you put on 4 pairs of socks and Air Force 1s with inserts");
                System.out.println("With newly found false confidence you decide you have 2 paths in life");
                System.out.println("1. Join a sports team.\n2. Go to university for coding.");
                int option2B = scan.nextInt();
                if (option2B == 1){
                    System.out.println("You try out for the teams and you end up being a trampoline dunker");
                    System.out.print("You make a huge boom in all of you plays leading to you getting");
                    System.out.print(" scouted by a scout from the 67ers do you\n1. Join.\n2. Reject.\n");
                    int option3B = scan.nextInt();
                    if (option3B == 1){
                        System.out.println("You accept and now your a pro you hope someone will look up to you");
                        System.out.println("You make strides as a pro with no-one being any wiser about your height");
                        System.out.print("when you are about to make a dunk you feel your shoes start to fall off");
                        System.out.print(" how do you react\n1. Avoid the dunk and fix your shoes.\n2. Do nothing and complete the dunk.\n");
                        int option4B = scan.nextInt();
                        if (option4B == 1){
                            System.out.println("With you fixing your shoes you throw the chances of winning");
                            System.out.print("You become ostracized your teammates said you came up short");
                            System.out.print(" for something as small your shoes\n");
                            System.out.println("Ending:\n       Faulty Shoes");
                        }
                        else{
                            System.out.print("You did it you made the dunk but everyone is silent");
                            System.out.print(" you are shunned not only are you short but you lied");
                            System.out.print("\nyou were fired and thrown out on the streets left to fend for yourself\n");
                            System.out.println("Ending:\n       Liar Exposed");
                        }
                    }
                    else{
                        System.out.println("You reject the offer months past you wait for another offer");
                        System.out.println("After scouts saw you reject the best offer you had you were out casted");
                        System.out.println("That marked the end of your career you were know as the greatest fool of your time");
                        System.out.println("Ending:\n       The Fool");
                    }
                }
                else{
                    System.out.print("You apply to many colleges and you get into Wilmington university");
                    System.out.print(" it's the first day you enter the Computer Science room");
                    System.out.print(" the teacher Dr.Lehman has a mixed presence where should you sit");
                    System.out.println("\n1. The very back.\n2. The front row.");
                    int option5B = scan.nextInt();
                    if (option5B == 1){
                        System.out.println("You sit in the back and Lehman says to those in the back he expects you to fail");
                        System.out.println("He lectures the class for a while and you day dream until he calls on you");
                        System.out.println("He asks what are 8-bits used for but since you weren't paying attention you can't respond");
                        System.out.println("When you try to explain why you don't know he starts saying baaababa");
                        System.out.print("Large amount of time has passed and you are taking a test");
                        System.out.print(" and with doing poorly\non the other test you have no choice to pass this to not fail");
                        System.out.print(" but never paying attention caught up to you and you ended up failing\n");
                        System.out.println("Ending:\n       Short Minded");
                    }
                    else{
                        System.out.println("You sit down in the front of the class and " +
                                " Lehman calls you and the other sitting there the smart ones");
                        System.out.println("He lectures the class for a while and then calls on you");
                        System.out.println("He asked what kind of language is Java\n1. OOP.\n2. Procedural");
                        int option6B = scan.nextInt();
                        if (option6B == 1){
                            System.out.println("You respond with Object Oriented Programming");
                            System.out.println("You are correct and get applauded Lehman tell you to keep up the good work");
                            System.out.println("How do you use the praise\n1. Try even harder.\n2. Keep the same effort.");
                            int option7B = scan.nextInt();
                            if (option7B == 1){
                                System.out.println("You put in tremendous effort and you rise to being the best in your class");
                                System.out.println("With the help for the teacher you get your name out into the computer science world");
                                System.out.println("Sometime passes and you graduate with highest scores in the country");
                                System.out.println("you get an offer for a upper position off a company what do you do");
                                System.out.println("1. Deny the offer and go your own way.\n2. Accept the offer and begin work.");
                                int option8B = scan.nextInt();
                                if (option8B == 1){
                                    System.out.println("You deny the offer and you decided to follow what you felt passionate about");
                                    System.out.println("You start a business were it teaches youth how to code");
                                    System.out.println("Thanks to all of your hard work Prophet institute recognizes you");
                                    System.out.println("This is your biggest and proudest moment");
                                    System.out.println("Ending:\n       Short Pride");
                                }
                                else{
                                    System.out.println("The offer was accepted after sometime working you felt burnt out");
                                    System.out.println("With being burnt out you realized this job was meant to trap you");
                                    System.out.println("It sucked away what made you special.....\nyou realise height never mattered but it was to late");
                                    System.out.println("Ending:\n       Short Lived Will");
                                }
                            }
                            else{
                                System.out.println("Since you didn't try more then you needed you didn't place high");
                                System.out.println("You didn't show yourself on a high level you placed average you didn't try to shine brighter");
                                System.out.println("You graduated but you never shined bright leading to you not amounting to much");
                                System.out.println("Ending:\n       Came Up Short");
                            }
                        }
                        else{
                            System.out.println("You wrong yet you were so confident you tried answering again but wrong again");
                            System.out.println("The teacher says to everyone this is what happens when you don't pay attention");
                            System.out.println("You feel great shame greater then that of your low height you run out of the class");
                            System.out.println("While your class mates laughed at you leading to you never returning");
                            System.out.println("Ending:\n       Short Lived Potential");
                        }
                    }
                }
            }
        }
        else{

        }
    }
}