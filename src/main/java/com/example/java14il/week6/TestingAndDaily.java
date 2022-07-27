package com.example.java14il.week6;

/**
 * TDD
 *      1. analyze requirement
 *      2. find all corner cases
 *      3. design architecture / data flow
 *      4. class + interface skeleton (without implementation)
 *      5. write test cases
 *      6. finish method body impl
 *      7. run test
 *      8. debug
 *
 *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *   *
 *   Jacoco => 80% code coverage
 *   1. Unit Test => Junit5 + Mockito
 *      service -> repository
 *      EmployeeService {
 *          filterEmployee() {
 *              List<Employee> emp = employeeRepository.getEmployees(); //dummy data
 *              //emp
 *          }
 *      }
 *
 *
 *      Mockito => mock framework
 *      1. get mock instance (employeeRepository)
 *      2. java impl: new EmployeeService(employeeRepository)
 *         spring env: @Mock + @InjectMock
 *      3. when(employeeRepository.getEmployees()).thenReturn(dummy data)
 *      4. Asserts.assertTrue(employeeService.filterEmployee().equals(..))
 *   2. Integration Test => MockMVC (code)
 *      mockMvc.perform() => generate request
 *   3. Integration Test => postman (tool)
 *   4. Function test
 *   5. performance test => Jmeter
 *
 *   ..
 *    *    *    *    *    *    *    *    *    *    *    *    *    *    *
 *   Agile scrum
 *   Sprint => 2 weeks
 *   Production backlog => TODO , sorted by priority
 *   Jira(tool)
 *      Todo stories   |   Tom     |      Jerry     |  Finished stories
 *       story1          story2          story3             Story5, 6, story2
 *
 *   1. Sprint planning meeting => at the start of sprint
 *        a. get some stories from production backlog
 *        b. estimate points of each story
 *              fibonacci ->  1 2 3 5 8 difficulty level
 *              hour      ->  1 point = 0.5 h / 1 h / 2 h
 *
 *   2. Daily stand up meeting => everyday morning / afternoon
 *        a. 15 - 30min
 *        b. what you done yesterday, what will you do today.
 *   3. Retrospective meeting => at the end of sprint
 *        a. good points in this sprint
 *        b. bad things in this sprint
 *        ------------
 *        a. tech stacks sharing section
 *        ------------
 *        a. happy hour
 *   4. Demo review meeting => every few sprints
 *   5. Coding meeting time
 *        a. meeting with frontend developer
 *        b. meeting with BA / QA / Manager (requirement clarification)
 *        c. meeting with Scrum master (issues / story)
 *        e. other meetings...
 *        f. TDD
 *              checkout new feature branch
 *              1. analyze requirement
 *              2. find all corner cases
 *              3. design architecture / data flow => write down your design / start from endpoint
 *              4. class + interface skeleton (without implementation)
 *              5. write test cases
 *              6. finish method body impl
 *              7. run test
 *              8. debug
 *              merge code back to dev branch (handle conflict)
 *        g. pull request code review
 *              a. leader / peers
 *              ------------------
 *              a. schedule meeting (1 on 1 code review)
 *        h. merge code -> trigger pipeline (dev ops team)
 *              DEV env -> Jenkins pipeline 1 -> QA env -> Jenkins pipeline 2 -> stage env  -> pre-production env .. -> PROD env
 *                          a. build
 *                          b. test
 *                          e. generate report => push report to Sonarqube(tool)
 *                          f. package
 *                          g. deploy
 *                          h. (automation test after deployment)
 *
 *   6. Production support (debug / ticket)
 *        a. bug report (details: feedback / issues / how to reproduce / user id..)
 *        b. search related (search Splunk by keyword(userid.., co-relation id))
 *        c. analyze + re-produce it in local env
 *           check heap dump / Jprofiler to analyze heap dump
 *           fix bug + rewrite unit test => have a meeting to explain the bug to manager
 *        f. aws / linux environment (setting + configuration) => firewall / loadbalancer
 *        g. database data in-consistency => rollback data => check issues
 *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *    *
 *    Tomorrow :
 *      1. AWS services
 *      2. ECS + docker container
 *      3. 1 on 1 meeting
 *
 */