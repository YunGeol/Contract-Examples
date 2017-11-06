org.springframework.cloud.contract.spec.Contract.make {
    description("""
        Represents a successful scenario of getting a beer
        
        ```
        given:
            client is old enough
        when:
            he applies for a beer
        then:
            we'll grant him the beer
        ```

    """)
    request {
        method 'POST'
        url '/check'
        body(
                age: 22
        )
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 200
        body("""
            {
                "status": "OK"
            }
            """)
        headers {
            contentType(applicationJson())
        }
    }
}
