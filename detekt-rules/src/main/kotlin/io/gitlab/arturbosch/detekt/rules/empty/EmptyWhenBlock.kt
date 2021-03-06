package io.gitlab.arturbosch.detekt.rules.empty

import io.gitlab.arturbosch.detekt.api.CodeSmell
import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.Entity
import org.jetbrains.kotlin.psi.KtWhenExpression

/**
 * @active since v1.0.0
 * @author Artur Bosch
 * @author Marvin Ramin
 */
class EmptyWhenBlock(config: Config) : EmptyRule(config) {

	override fun visitWhenExpression(expression: KtWhenExpression) {
		if (expression.entries.isEmpty()) {
			report(CodeSmell(issue, Entity.from(expression), message = ""))
		}
	}

}
