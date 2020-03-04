import com.company.BacklogItems.BacklogItem;
import com.company.BacklogItems.DoingState;
import com.company.BacklogItems.DoneState;
import com.company.BacklogItems.ToDoState;
import com.company.Forum.Comment;
import com.company.Forum.Forum;
import com.company.Forum.ForumThread;
import com.company.Forum.ForumThreadFactory;
import com.company.Project.Project;
import com.company.Project.SoftwareReleaseStrategy;
import com.company.Project.Sprint;
import com.company.Project.SprintFeedbackStrategy;
import com.company.ReportGenerator.PdfGenerator;
import com.company.ReportGenerator.ReportGenerator;
import com.company.ReportGenerator.WordDocGenerator;
import com.company.Users.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AvansTest {

    private Project avansProject;
    private Sprint sprint_2;
    private User henkDeProductOwner;
    private Date sprintStartDate;
    private Date sprintEndDate;
    private SoftwareReleaseStrategy softwareReleaseStrategy;
    private ForumThreadFactory forumThreadFactory;

    @BeforeAll
    void BeforeAllTests(){

        ArrayList<Sprint> sprintsInProject = new ArrayList<>();
        ArrayList<BacklogItem> projectBacklog = new ArrayList<>();

        //Maak een project met een projectowner
        henkDeProductOwner = new User();
        avansProject = new Project("Avans Project", "Dit is een Avans project.",henkDeProductOwner, projectBacklog, sprintsInProject);

        //Start en einddatums
        sprintStartDate = new Date();
        sprintEndDate = new Date();

        //Zet de strategie voor deze sprint
        softwareReleaseStrategy = new SoftwareReleaseStrategy();

        avansProject.AddSprint(sprint_2);
        forumThreadFactory = new ForumThreadFactory();
    }

    @Test
    @Order(1)
    void CanOnlyChangeDataInPlanningState(){
        sprint_2 = new Sprint("Eerste Sprint", sprintStartDate, sprintEndDate, henkDeProductOwner, softwareReleaseStrategy);

        //Verander de data van de sprint, dit zou moeten kunnen.
        sprint_2.SetSprintData("Verandering", sprintStartDate, sprintEndDate);
        System.out.println(sprint_2.getName());

        //Zou veranderd moeten zijn.
        assertEquals("Verandering",sprint_2.getName());

        sprint_2.GoNext();

        //Verander de data van de sprint, dit zou NIET moeten kunnen.
        sprint_2.SetSprintData("GeenVerandering", sprintStartDate, sprintEndDate);

        //Zou veranderd moeten zijn.
        assertEquals("Verandering",sprint_2.getName());

        sprint_2.GoNext();
        //Verander de data van de sprint, dit zou NIET moeten kunnen.
        sprint_2.SetSprintData("GeenVerandering", sprintStartDate, sprintEndDate);

        //Zou veranderd moeten zijn.
        assertEquals("Verandering",sprint_2.getName());

        sprint_2.GoNext();
    }

    @Test
    @Order(2)
    void CanGenerateReportWithDifferentGenerators(){
        ArrayList<User> users = new ArrayList<>();
        User erik = new User();
        users.add(erik);

        //Return een word document (in dit geval een string)
        WordDocGenerator wordDocGenerator = new WordDocGenerator();
        String s1 = wordDocGenerator.GenerateReport(sprint_2, users);
        assertEquals(s1,"WORD");

        //Return een pdf document (in dit geval een string)
        PdfGenerator pdfGenerator = new PdfGenerator();
        String s2 = pdfGenerator.GenerateReport(sprint_2, users);
        assertEquals(s2,"PDF");
    }

    @Test
    @Order(3)
    void CanOnlyGoBackInDoneState(){
        User developerGerrie = new User();

        BacklogItem backlogItem = new BacklogItem("BacklogItem","Dit is een backlogitem", developerGerrie);

        assertEquals(backlogItem.GetState() instanceof ToDoState, true);

        backlogItem.GoNext();

        assertEquals(backlogItem.GetState() instanceof DoingState, true);
        backlogItem.SetBackToToDo();
        assertEquals(backlogItem.GetState() instanceof ToDoState, false);

        backlogItem.GetBacklogTasks().get(0).SetBackLogTaskToDone();
        backlogItem.GoNext();

        assertEquals(backlogItem.GetState() instanceof DoneState, true);
        backlogItem.SetBackToToDo();
        assertEquals(backlogItem.GetState() instanceof ToDoState, true);
    }

    @Test
    @Order(4)
    void CanAddCommentsToBacklogItemForumThread(){
        User developerRichard = new User();

        BacklogItem backlogItem2 = new BacklogItem("BacklogItem","Dit is een backlogitem", developerRichard);

        ForumThread forumThread = forumThreadFactory.CreateForumThread(2, "ForumThread2","Ja", backlogItem2);

        Comment c = new Comment("Comment1", developerRichard);

        //Dit zou moeten kunnen
        forumThread.AddComment(c);

        //Kijk of er 1 comment bij toegevoegd is.
        assertEquals(forumThread.GetAllComments().size(), 1);

        backlogItem2.GoNext();
        backlogItem2.GetBacklogTasks().get(0).SetBackLogTaskToDone();
        backlogItem2.GoNext();

        //Dit zou niet moeten kunnen
        Comment c2 = new Comment("Comment1", developerRichard);
        forumThread.AddComment(c2);

        //Dit zou moeten kunnen
        forumThread.AddComment(c);

        assertEquals(forumThread.GetAllComments().size(), 1);
    }
}
