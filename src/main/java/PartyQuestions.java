import java.util.List;
import java.util.ArrayList;

//The party questions class returns the questions for the program to use 
public class PartyQuestions
{

  //List of the questions
  private List<String> questions = new ArrayList<String>();

  public PartyQuestions()
  {

  }

  //Returns the current hours for the period
  public List<String> populateQuestions()
  {
    this.questions.add("What are your opinions on free health care for all? \n1.Everyone should have it! \n2.Good if done properly. \n3.Only those at the lowest poverty levels. \n4.Absolutely not.");

    this.questions.add("What are your feelings toward student loan forgiveness? \n1.They should have to pay a percentage of the total before being applicable. \n2.People should plan and make better decisions before taking excessive loans. \n3.It needs to happen. \n4.It is unfair to those who have fully paid loans.");

    this.questions.add("How did you feel about the Trump Presidency? \n1.It was a change that America needed. \n2.I believe Trump caused great harm to America’s core. \n3.I believe Trump’s presidency was of immense benefit to the American people. \n4.He was neither harmful nor beneficial.");

    questions.add("How did you feel about the Obama Presidency? \n1.It was a change that America needed. \n2.I believe Obama caused great harm to America’s core. \n3.I believe Obama’s presidency was of immense benefit to the American people. \n4.He was neither harmful nor beneficial.");

    this.questions.add("How do you feel about the January 6th incident? \n1.It was unavoidable. \n2.It was an abhorrent threat to the foundations of American Values. \n3.I was in full support of the actions that took place. \n4.I have no strong opinions.");

    questions.add("How do you feel about the death penalty? \n1.It is never justified. \n2.Only in the most extreme cases. \n3.I am in full favor. \n4.Only with specific guidelines (Ex. 3 Strikes)");

    this.questions.add("What are your feelings about increased gun control? \n1.It is a threat to the rights provided by the second amendment. \n2.It is very needed in these times. \n3.I will never give up my firearms. \n4.I am for the second amendment, but additional restrictions should be considered.");

    this.questions.add("Out of the following choices, which change would you make if you had the power? \n1.End world hunger. \n2.End global warming. \n3.End poverty. \n4.Personal enrichment (land, wealth, fame, health, etc.).");

    this.questions.add("Do you believe in the right to shelter for all? \n1.Yes, every human deserves safety and shelter. \n2.Right to shelter should be primarily for citizens and residents. \n3.Children and other vulnerable persons should have it. \n4.No, able adults should have to fend for themselves.");

    this.questions.add("How do you feel about individuals needing public assistance? \n1.Short term is okay, long term is not. \n2.Long term is okay, some people face more challenges and need more help than others. \n3.No, able adults should be able to fend for themselves. \n4.Short term and long term are okay, but there needs to be programs that provide opportunities for individuals beyond public benefits.");

    this.questions.add("How dire do you feel the global warming crisis is to our planet? \n1.Extremely dire. \n2.We still have time to turn things around and will adapt. \n3.There is no hope. \n4.Global warming will not impact us in a meaningful way.");

    this.questions.add("How do you feel about reparations? \n1.The future generation cannot be responsible for the past. \n2.It is much needed to bridge certain social and economic gaps in America. \n3.It is needed, but nearly impossible to quantify or implement effectively. \n4.It is a fully or somewhat entitled aspiration that needs to be brought to an end.");

    this.questions.add("What are your thoughts on universal basic income? \n1.No, you have to work for the things you have. \n2.Yes, it gives everyone increased opportunity and quality of life. \n3.Only if it is supplemental vs primary. \n4.It will potentially encourage many to leave the workforce if it isn’t appropriately administered.");

    this.questions.add("How do you feel about the decriminalization of illegal substances? \n1.It will provide better intervention for individuals with substance abuse problems. \n2.It will enable the behavior further. \n3.There is nothing wrong with the current system. \n4.The current system is too lenient.");

    this.questions.add("What do you think about the government’s role in public education? \n1.It should play more of a role in education. \n2.The current level of involvement is appropriate. \n3.It should play less of a role in education. \n4.The entire system needs to be overhauled.");

    this.questions.add("How do you feel about military spending in America? \n1.The government spends far too much money on the military. \n2.It is expensive, but necessary. \n3.They should spend more on the military. \n4.The government should spend less on the assistance of other countries.");

    this.questions.add("Do you have feelings of racial superiority? \n1.I have pride in my race, but not superiority. \n2.I don’t believe in racial superiority. \n3.Yes, I believe my race is more capable in some or all departments vs others. \n4.Yes, and I believe some races contribute less to the world than others.");

    this.questions.add("Do you believe someone who does not contribute to a positive society deserves to share the same rights of those that do not? \n1.Yes, all individuals are entitled to their own pursuit of freedom. \n2.No, in order for society to function it needs productive individuals. \n3.Only in cases of those who abuse those rights (Ex. encroach on other’s rights as a result). \n4.Only in cases of the commission of serious offenses.");

    this.questions.add("Do you believe there are certain kinds of speech or media the government should censor? \n1. would never be an acceptable outcome. \n2.Only in situations that may directly affect the safety and health of the country. \n3.Certain speech should be censored, such as hateful rhetoric based on many protected statuses (such as race, religion, etc.) \n4.The people should decide what is acceptable in these matters.");

    this.questions.add("Should undocumented workers be targeted and deported? \n1.Yes, there is a proper channel in which to do things. \n2.If they are a contributing member of the country then they should not be targeted. \n3.No, individuals should have the right to shelter and to start a productive life here. \n4.They should not be targeted, but deported if they are arrested or involved in negative activity.");

    return this.questions;
  }


}