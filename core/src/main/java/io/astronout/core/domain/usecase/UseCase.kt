package io.astronout.core.domain.usecase

interface UseCase<ParamType, ReturnType> {
    operator fun invoke(param: ParamType): ReturnType
}

object NoParams