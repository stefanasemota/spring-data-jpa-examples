package net.petrikainulainen.springdata.jpa.todo;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import net.petrikainulainen.springdata.jpa.TodoConstants;
import net.petrikainulainen.springdata.jpa.config.ExampleApplicationContext;
import net.petrikainulainen.springdata.jpa.config.Profiles;
import net.petrikainulainen.springdata.jpa.web.ColumnSensingReplacementDataSetLoader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Petri Kainulainen
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(Profiles.INTEGRATION_TEST)
@ContextConfiguration(classes = {ExampleApplicationContext.class})
@DbUnitConfiguration(dataSetLoader = ColumnSensingReplacementDataSetLoader.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@WebAppConfiguration
@DatabaseSetup("todo-entries.xml")
public class ITTodoRepositoryTest {

    @Autowired
    private TodoRepository repository;

    @Test
    public void findByDescriptionContainsOrTitleContainsAllIgnoreCase_DescriptionOfOneTodoEntryMatches_ShouldReturnListThatHasOneTodoEntry() {
        List<Todo> todoEntries = repository.findByDescriptionContainsOrTitleContainsAllIgnoreCase(TodoConstants.SEARCH_TERM_DESCRIPTION_MATCHES,
                TodoConstants.SEARCH_TERM_DESCRIPTION_MATCHES
        );
        assertThat(todoEntries).hasSize(1);

        Todo todoEntry = todoEntries.get(0);
        assertThat(todoEntry.getId()).isEqualTo(TodoConstants.ID);
    }

    @Test
    public void findByDescriptionContainsOrTitleContainsAllIgnoreCase_NoMatches_ShouldReturnEmptyList() {
        List<Todo> todoEntries = repository.findByDescriptionContainsOrTitleContainsAllIgnoreCase(TodoConstants.SEARCH_TERM_NO_MATCH,
                TodoConstants.SEARCH_TERM_NO_MATCH
        );
        assertThat(todoEntries).isEmpty();
    }

    @Test
    public void findByDescriptionContainsOrTitleContainsAllIgnoreCase_TitleOfOneTodoEntryMatches_ShouldReturnListThatHasOneTodoEntry() {
        List<Todo> todoEntries = repository.findByDescriptionContainsOrTitleContainsAllIgnoreCase(TodoConstants.SEARCH_TERM_TITLE_MATCHES,
                TodoConstants.SEARCH_TERM_TITLE_MATCHES
        );
        assertThat(todoEntries).hasSize(1);

        Todo todoEntry = todoEntries.get(0);
        assertThat(todoEntry.getId()).isEqualTo(TodoConstants.ID);
    }

    @Test
    public void findBySearchTermNamed_DescriptionOfOneTodoEntryMatches_ShouldReturnListThatHasOneTodoEntry() {
        List<Todo> todoEntries = repository.findBySearchTermNamed(TodoConstants.SEARCH_TERM_DESCRIPTION_MATCHES);
        assertThat(todoEntries).hasSize(1);

        Todo todoEntry = todoEntries.get(0);
        assertThat(todoEntry.getId()).isEqualTo(TodoConstants.ID);
    }

    @Test
    public void findBySearchTermNamed_NoMatches_ShouldReturnEmptyList() {
        List<Todo> todoEntries = repository.findBySearchTermNamed(TodoConstants.SEARCH_TERM_NO_MATCH);
        assertThat(todoEntries).isEmpty();
    }

    @Test
    public void findBySearchTermNamed_TitleOfOneTodoEntryMatches_ShouldReturnListThatHasOneTodoEntry() {
        List<Todo> todoEntries = repository.findBySearchTermNamed(TodoConstants.SEARCH_TERM_TITLE_MATCHES);
        assertThat(todoEntries).hasSize(1);

        Todo todoEntry = todoEntries.get(0);
        assertThat(todoEntry.getId()).isEqualTo(TodoConstants.ID);
    }

    @Test
    public void findBySearchTermNamedNative_DescriptionOfOneTodoEntryMatches_ShouldReturnListThatHasOneTodoEntry() {
        List<Todo> todoEntries = repository.findBySearchTermNamedNative(TodoConstants.SEARCH_TERM_DESCRIPTION_MATCHES);
        assertThat(todoEntries).hasSize(1);

        Todo todoEntry = todoEntries.get(0);
        assertThat(todoEntry.getId()).isEqualTo(TodoConstants.ID);
    }

    @Test
    public void findBySearchTermNamedNative_NoMatches_ShouldReturnEmptyList() {
        List<Todo> todoEntries = repository.findBySearchTermNamedNative(TodoConstants.SEARCH_TERM_NO_MATCH);
        assertThat(todoEntries).isEmpty();
    }

    @Test
    public void findBySearchTermNamedNative_TitleOfOneTodoEntryMatches_ShouldReturnListThatHasOneTodoEntry() {
        List<Todo> todoEntries = repository.findBySearchTermNamedNative(TodoConstants.SEARCH_TERM_TITLE_MATCHES);
        assertThat(todoEntries).hasSize(1);

        Todo todoEntry = todoEntries.get(0);
        assertThat(todoEntry.getId()).isEqualTo(TodoConstants.ID);
    }

    @Test
    public void findBySearchTermNamedFile_DescriptionOfOneTodoEntryMatches_ShouldReturnListThatHasOneTodoEntry() {
        List<Todo> todoEntries = repository.findBySearchTermNamedFile(TodoConstants.SEARCH_TERM_DESCRIPTION_MATCHES);
        assertThat(todoEntries).hasSize(1);

        Todo todoEntry = todoEntries.get(0);
        assertThat(todoEntry.getId()).isEqualTo(TodoConstants.ID);
    }

    @Test
    public void findBySearchTermNamedFile_NoMatches_ShouldReturnEmptyList() {
        List<Todo> todoEntries = repository.findBySearchTermNamedFile(TodoConstants.SEARCH_TERM_NO_MATCH);
        assertThat(todoEntries).isEmpty();
    }

    @Test
    public void findBySearchTermNamedFile_TitleOfOneTodoEntryMatches_ShouldReturnListThatHasOneTodoEntry() {
        List<Todo> todoEntries = repository.findBySearchTermNamedFile(TodoConstants.SEARCH_TERM_TITLE_MATCHES);
        assertThat(todoEntries).hasSize(1);

        Todo todoEntry = todoEntries.get(0);
        assertThat(todoEntry.getId()).isEqualTo(TodoConstants.ID);
    }

    @Test
    public void findBySearchTermNamedNativeFile_DescriptionOfOneTodoEntryMatches_ShouldReturnListThatHasOneTodoEntry() {
        List<Todo> todoEntries = repository.findBySearchTermNamedNativeFile(TodoConstants.SEARCH_TERM_DESCRIPTION_MATCHES);
        assertThat(todoEntries).hasSize(1);

        Todo todoEntry = todoEntries.get(0);
        assertThat(todoEntry.getId()).isEqualTo(TodoConstants.ID);
    }

    @Test
    public void findBySearchTermNamedNativeFile_NoMatches_ShouldReturnEmptyList() {
        List<Todo> todoEntries = repository.findBySearchTermNamedNativeFile(TodoConstants.SEARCH_TERM_NO_MATCH);
        assertThat(todoEntries).isEmpty();
    }

    @Test
    public void findBySearchTermNamedNativeFile_TitleOfOneTodoEntryMatches_ShouldReturnListThatHasOneTodoEntry() {
        List<Todo> todoEntries = repository.findBySearchTermNamedNativeFile(TodoConstants.SEARCH_TERM_TITLE_MATCHES);
        assertThat(todoEntries).hasSize(1);

        Todo todoEntry = todoEntries.get(0);
        assertThat(todoEntry.getId()).isEqualTo(TodoConstants.ID);
    }

    @Test
    public void findBySearchTermNamedOrmXml_DescriptionOfOneTodoEntryMatches_ShouldReturnListThatHasOneTodoEntry() {
        List<Todo> todoEntries = repository.findBySearchTermNamedOrmXml(TodoConstants.SEARCH_TERM_DESCRIPTION_MATCHES);
        assertThat(todoEntries).hasSize(1);

        Todo todoEntry = todoEntries.get(0);
        assertThat(todoEntry.getId()).isEqualTo(TodoConstants.ID);
    }

    @Test
    public void findBySearchTermNamedOrmXml_NoMatches_ShouldReturnEmptyList() {
        List<Todo> todoEntries = repository.findBySearchTermNamedOrmXml(TodoConstants.SEARCH_TERM_NO_MATCH);
        assertThat(todoEntries).isEmpty();
    }

    @Test
    public void findBySearchTermNamedOrmXml_TitleOfOneTodoEntryMatches_ShouldReturnListThatHasOneTodoEntry() {
        List<Todo> todoEntries = repository.findBySearchTermNamedOrmXml(TodoConstants.SEARCH_TERM_TITLE_MATCHES);
        assertThat(todoEntries).hasSize(1);

        Todo todoEntry = todoEntries.get(0);
        assertThat(todoEntry.getId()).isEqualTo(TodoConstants.ID);
    }

    @Test
    public void findBySearchTermNamedNativeOrmXml_DescriptionOfOneTodoEntryMatches_ShouldReturnListThatHasOneTodoEntry() {
        List<Todo> todoEntries = repository.findBySearchTermNamedNativeOrmXml(TodoConstants.SEARCH_TERM_DESCRIPTION_MATCHES);
        assertThat(todoEntries).hasSize(1);

        Todo todoEntry = todoEntries.get(0);
        assertThat(todoEntry.getId()).isEqualTo(TodoConstants.ID);
    }

    @Test
    public void findBySearchTermNamedNativeOrmXml_NoMatches_ShouldReturnEmptyList() {
        List<Todo> todoEntries = repository.findBySearchTermNamedNativeOrmXml(TodoConstants.SEARCH_TERM_NO_MATCH);
        assertThat(todoEntries).isEmpty();
    }

    @Test
    public void findBySearchTermNamedNativeOrmXml_TitleOfOneTodoEntryMatches_ShouldReturnListThatHasOneTodoEntry() {
        List<Todo> todoEntries = repository.findBySearchTermNamedNativeOrmXml(TodoConstants.SEARCH_TERM_TITLE_MATCHES);
        assertThat(todoEntries).hasSize(1);

        Todo todoEntry = todoEntries.get(0);
        assertThat(todoEntry.getId()).isEqualTo(TodoConstants.ID);
    }

    @Test
    public void findBySearchTerm_DescriptionOfOneTodoEntryMatches_ShouldReturnListThatHasOneTodoEntry() {
        List<Todo> todoEntries = repository.findBySearchTerm(TodoConstants.SEARCH_TERM_DESCRIPTION_MATCHES);
        assertThat(todoEntries).hasSize(1);

        Todo todoEntry = todoEntries.get(0);
        assertThat(todoEntry.getId()).isEqualTo(TodoConstants.ID);
    }

    @Test
    public void findBySearchTerm_NoMatch_ShouldReturnEmptyList() {
        List<Todo> todoEntries = repository.findBySearchTerm(TodoConstants.SEARCH_TERM_NO_MATCH);
        assertThat(todoEntries).isEmpty();
    }

    @Test
    public void findBySearchTerm_TitleOfOneTodoEntryMatches_ShouldReturnListThatHasOneTodoEntry() {
        List<Todo> todoEntries = repository.findBySearchTerm(TodoConstants.SEARCH_TERM_TITLE_MATCHES);
        assertThat(todoEntries).hasSize(1);

        Todo todoEntry = todoEntries.get(0);
        assertThat(todoEntry.getId()).isEqualTo(TodoConstants.ID);
    }

    @Test
    public void findBySearchTermNative_DescriptionOfOneTodoEntryMatches_ShouldReturnListThatHasOneTodoEntry() {
        List<Todo> todoEntries = repository.findBySearchTermNative(TodoConstants.SEARCH_TERM_DESCRIPTION_MATCHES);
        assertThat(todoEntries).hasSize(1);

        Todo todoEntry = todoEntries.get(0);
        assertThat(todoEntry.getId()).isEqualTo(TodoConstants.ID);
    }

    @Test
    public void findBySearchTermNative_NoMatch_ShouldReturnEmptyList() {
        List<Todo> todoEntries = repository.findBySearchTermNative(TodoConstants.SEARCH_TERM_NO_MATCH);
        assertThat(todoEntries).isEmpty();
    }

    @Test
    public void findBySearchTermNative_TitleOfOneTodoEntryMatches_ShouldReturnListThatHasOneTodoEntry() {
        List<Todo> todoEntries = repository.findBySearchTermNative(TodoConstants.SEARCH_TERM_TITLE_MATCHES);
        assertThat(todoEntries).hasSize(1);

        Todo todoEntry = todoEntries.get(0);
        assertThat(todoEntry.getId()).isEqualTo(TodoConstants.ID);
    }
}
