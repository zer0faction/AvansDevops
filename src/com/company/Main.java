package com.company;

import com.company.Forum.Comment;
import com.company.Forum.ForumThread;
import com.company.BacklogItems.BacklogItem;
import com.company.Project.Project;
import com.company.Project.Sprint;
import com.company.Project.SprintFeedbackStrategy;
import com.company.Users.EmailAdapter;
import com.company.Users.SlackAdapter;
import com.company.Users.User;

import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        System.out.println("AVANS DEVOPS APPLICATIE");
        System.out.println("-----------------------");


        ArrayList<Sprint> sprintsInProject = new ArrayList<>();
        ArrayList<BacklogItem> projectBacklog = new ArrayList<>();

        Project avansProject = new Project("Avans Project", "Dit is een Avans project.", projectBacklog, sprintsInProject);

        Date sprintStartDate = new Date();
        Date sprintEndDate = new Date();

        SprintFeedbackStrategy sprintFeedbackStrategy = new SprintFeedbackStrategy();
        Sprint sprint = new Sprint("Eerste Sprint", sprintStartDate, sprintEndDate, sprintMaster, sprintFeedbackStrategy);

        //Voeg sprint toe aan project
        avansProject.AddSprint(sprint);

        User gerrit = new User();
        gerrit.setName("Gerrit");
        gerrit.setEmail("gerrit@email.com");

        //Gerrit kiest ervoor om zijn meldingen met EMAIl te ontvangen
        EmailAdapter emailAdapter = new EmailAdapter();
        gerrit.Subscribe(emailAdapter);

        User pietje = new User();
        pietje.setName("pietje");
        pietje.setEmail("pietje@email.com");
        pietje.setSlackUsername("pietjeSLACK");

        //Pietje kiest ervoor om zijn meldingen zowel met EMAIL als met SLACK te ontvangen
        SlackAdapter slackAdapter = new SlackAdapter();
        pietje.Subscribe(emailAdapter);
        pietje.Subscribe(slackAdapter);

        //onderstaande zou de aanpassingen door moeten spelen
        sprint.SetSprintData("Eerste Sprint MET NAAMWIJZIGING", sprintStartDate, sprintEndDate);
        BacklogItem backlogItem1 = new BacklogItem("Eerste backlogitem", "Eerste backlogitem", gerrit);
        avansProject.AddBacklogItem(backlogItem1);
        sprint.AddBacklogItem(backlogItem1);

        //ga naar de volgende state van de sprint, in dit geval "implementation state"
        sprint.GoNext();

        //onderstaande zou een error moeten geven
        sprint.SetSprintData("Eerste Sprint MET NAAMWIJZIGING", sprintStartDate, sprintEndDate);
        BacklogItem backlogItem2 = new BacklogItem("Tweede backlogitem","Tweede backlogitem", gerrit);
        sprint.AddBacklogItem(backlogItem2);

        //hij kan echter wel aan het project worden toegevoegd.
        avansProject.AddBacklogItem(backlogItem2);

        //Zet naar DOING
        backlogItem1.GoNext();

        //Voeg een thread toe voor BackLogItem1;
        ForumThread forumThread1 = new ForumThread("Help het gaat verkeerd", "Het komt niet goed", backlogItem1);
        avansProject.getProjectForum().AddForumThread(forumThread1);

        //Voeg comments toe aan de thread;
        Comment comment1 = new Comment("Ik help je wel", gerrit);
        Comment comment2 = new Comment("Ik help je ook wel", pietje);

        forumThread1.AddComment(comment1);
        forumThread1.AddComment(comment2);

        //Print alle comments van de thread;
        forumThread1.PrintAllComments();

        //Print alle threads;
        avansProject.getProjectForum().PrintAllForumThreads();

        //BacklogItem1 is te groot, dus we gaan taken onderverdelen. Voeg een extra taak toe met een andere User.
        backlogItem1.AddExtraBacklogTask("Eerste backlogitem - part II","",pietje);

        //Backlogitem1 is nog niet klaar: niet alle deeltaken zijn afgerond, hieronder zou een error moeten onstaan
        backlogItem1.GoNext();

        //Zet backlogitem task 0 en 1 naar done. Alle tasks in backlogitem zouden done moeten zijn nu.
        backlogItem1.GetBacklogTasks().get(0).SetBackLogTaskToDone();
        backlogItem1.GetBacklogTasks().get(1).SetBackLogTaskToDone();

        //Backlogitem1 is nu volledig afgerond, wordt nu naar DONE gezet
        backlogItem1.GoNext();

        //Omdat de backlogitem op DONE staat kunnen er als het goed is geen comments toegevoegd worden:
        Comment comment3 = new Comment("Deze comment gaat niet werken", gerrit);
        forumThread1.AddComment(comment3);

        //Er kan ook geen nieuwe thread voor aangemaakt worden:
        ForumThread forumThread2 = new ForumThread("Help het gaat verkeerd", "Het komt niet goed", backlogItem1);
        avansProject.getProjectForum().AddForumThread(forumThread2);

        //Backlogitem1 was nog niet goed afgerond, zet deze terug naar TODO
        //Iedereen die aan de taak zit en de scrummaster zou een bericht moeten ontvangen

        //Scrummaster aanmaken, zorgen dat hij emails ontvangt
        User scrumMasterRik = new User();
        scrumMasterRik.setEmail("scrummaster@email.com");
        scrumMasterRik.Subscribe(emailAdapter);

        backlogItem1.SetBackToToDo();


        //ga naar de volgende state van de sprint, in dit geval "finished state"
        sprint.GoNext();

    }
}
