package behaviouralSwitch.sentence

import spock.lang.Specification

class BehaviourSwitchSentenceTest extends Specification {

    //All tests in each package do the same thing
    //But I wanted to keep each step refactor for academic purposes
    //along its tests

    def final calculator = new Calculator()
    static final SUM = '+'
    static final SUBSTRACT = '-'
    static final MULTIPLICATION = 'x'
    static final NO_OP = '?'

    def "Sum operation"(final int n1, final int n2, final int res) {

        given:
            def final operator = SUM as char
        expect:
            calculator.calculate(operator, n1, n2) == res

        where:
            n1 | n2 || res
            2  | 3  || 5
            -3 | -1 || -4
            2  | 0  || 2
            0  | 0  || 0
            3  | -1 || 2
            4  | -4 || 0
    }

    def "Substract operation"(final int n1, final int n2, final int res) {

        given:
            def final operator = SUBSTRACT as char
        expect:
            calculator.calculate(operator, n1, n2) == res

        where:
            n1 | n2 || res
            2  | 3  || -1
            3  | 2  || 1
            -3 | -1 || -2
            2  | 0  || 2
            0  | 0  || 0
            3  | -1 || 4
            -3 | 1  || -4
            4  | 4  || 0
    }

    def "Multiply operation"(final int n1, final int n2, final int res) {

        given:
            def final operator = MULTIPLICATION as char
        expect:
            calculator.calculate(operator, n1, n2) == res

        where:
            n1 | n2 || res
            0  | 0  || 0
            0  | 2  || 0
            2  | 0  || 0
            2  | 1  || 2
            1  | 3  || 3
            3  | 2  || 6
            3  | -2 || -6
            -2 | 3  || -6
            -2 | -3 || 6
    }

    def "No operation exists throws invalid argument exception"() {

        given:
            def final operator = NO_OP as char
        when:
            calculator.calculate(operator, 0, 0)
        then:
            thrown IllegalArgumentException
    }

}
