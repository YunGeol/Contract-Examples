org.springframework.cloud.contract.spec.Contract.make {
    description("""
        Represents a successful scenario of getting a beer
        
        ```
        given:
            client is too young
        when:
            he applies for a beer
        then:
            we'll reject him
        ```
    """)
    request {
        method 'POST'
        url '/check'
        body(
                age: 17,
                name: "marcin"
        )
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 200
        body("""
            {
                "status": "NOT_OK"
            }
        """)
        headers {
            contentType(applicationJson())
        }
    }
}
