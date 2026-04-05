package stud.ganyushkin.sapr.service.policy

fun interface ComponentLabelPolicy {
    fun isAllowed(label: String): Boolean
}
