package br.com.felipezorzo.sonar.plsql.statements;

import static org.sonar.sslr.tests.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import br.com.felipezorzo.sonar.plsql.api.PlSqlGrammar;
import br.com.felipezorzo.sonar.plsql.api.RuleTest;

public class UpdateStatementTest extends RuleTest {

    @Before
    public void init() {
        setRootRule(PlSqlGrammar.UPDATE_STATEMENT);
    }
    
    @Test
    public void matchesSimpleUpdate() {
        assertThat(p).matches("update tab set x = 1;");
    }
    
    @Test
    public void matchesUpdateWithWhere() {
        assertThat(p).matches("update tab set x = 1 where y = 1;");
    }
    
    @Test
    public void matchesUpdateMultipleColumns() {
        assertThat(p).matches("update tab set x = 1, y = 1;");
    }
    
    @Test
    public void matchesUpdateWithAlias() {
        assertThat(p).matches("update tab t set t.x = 1;");
    }
    
    @Test
    public void matchesUpdateWithSchema() {
        assertThat(p).matches("update sch.tab set sch.tab.x = 1;");
    }
    
    @Test
    public void matchesLabeledUpdate() {
        assertThat(p).matches("<<foo>> update tab set x = 1;");
    }

}