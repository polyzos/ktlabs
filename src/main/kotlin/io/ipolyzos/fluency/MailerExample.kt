package io.ipolyzos.fluency

fun main() {
//    useMailer()
//    useMailerWithApply()
//    useMailerWithApply2()
//    useMailerWithRun()
//    useMailerWithLet()
    useMailerWithAlso()
}

class Mailer {
    val details = StringBuilder()
    fun from(addr: String) = details.append("from $addr...\n")
    fun to(addr: String) = details.append("to $addr...\n")
    fun subject(line: String) = details.append("subject $line...\n")
    fun body(message: String) = details.append("body $message...\n")
    fun send() = "...sending...\n$details"
}


fun useMailer() {
    val mailer = Mailer()
    mailer.from("builder@agiledeveloper.com")
    mailer.to("venkats@agiledeveloper.com")
    mailer.subject("Your code sucks")
    mailer.body("...details...")
    val result = mailer.send()
    println(result)
}


// Removing Repetitive References with apply
fun useMailerWithApply() = {
    val mailer: Mailer = Mailer()
        .apply { from("builder@agiledeveloper.com") }
        .apply { to("venkats@agiledeveloper.com") }
        .apply { subject("Your code sucks") }
        .apply { body("details") }
    val result = mailer.send()
    println(result)
}


fun useMailerWithApply2() = {
    val mailer: Mailer = Mailer()
        .apply {
            from("builder@agiledeveloper.com")
            to("venkats@agiledeveloper.com")
            subject("Your code sucks")
            body("details")
        }
    val result = mailer.send()
    println(result)
}

/**
 * To keep the target object at the end of a sequence of calls, use apply();
 * to keep the result of the last expression within the lambda instead, use run().
 *
 * In either case, use these methods only if you want to run the lambda
 * in the context of the target.
 * */
// use run to run the code instead of just apply which doesnt return a result
fun useMailerWithRun() {
    val result = Mailer().run {
        from("builder@agiledeveloper.com")
        to("venkats@agiledeveloper.com")
        subject("Your code sucks")
        body("details")
        send()
    }
    println(result)
}

// Passing an Object as Argument Using let
fun useMailerWithLet() {
    fun createMailer() = Mailer()
    fun prepareAndSend(mailer: Mailer) = mailer.run {
        from("builder@agiledeveloper.com")
        to("venkats@agiledeveloper.com")
        subject("Your code suks")
        body("details")
        send() }


    // option 1: you can do
    val mailer = createMailer()
    val result = prepareAndSend(mailer)
    println(result)

    // making it more fluent
//    val resultFluent = createMailer().let { prepareAndSend(it) }
    val resultFluent = createMailer().let(::prepareAndSend)
    println()
    println("Fluent Result:")
    println(resultFluent)
}


// The also() method is useful to chain a series of void functions
// that otherwise don’t fall into a call chain.
fun useMailerWithAlso() {
    fun createMailer() = Mailer()

    fun prepareMailer(mailer: Mailer): Unit {
        mailer.run {
            from("builder@agiledeveloper.com")
            to("venkats@agiledeveloper.com")
            subject("Your code suks")
            body("details")
        }
    }

    fun sendMail(mailer: Mailer): Unit { mailer.send()
        println("Mail sent")
    }

    createMailer()
        .apply(::prepareMailer)
        .apply(::sendMail)
}