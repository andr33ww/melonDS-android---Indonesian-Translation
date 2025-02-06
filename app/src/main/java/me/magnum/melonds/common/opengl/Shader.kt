package me.magnum.melonds.common.opengl

import android.opengl.GLES30

class Shader(
    private val programId: Int,
    val textureFiltering: Int,
) {
    val uniformMvp: Int
    val attribUv: Int
    val attribPos: Int
    val uniformTex: Int

    init {
        GLES30.glUseProgram(programId)
        uniformMvp = GLES30.glGetUniformLocation(programId, "MVP")
        attribUv = GLES30.glGetAttribLocation(programId, "vUV")
        attribPos = GLES30.glGetAttribLocation(programId, "vPos")
        uniformTex = GLES30.glGetUniformLocation(programId, "tex")
        GLES30.glUseProgram(0)
    }

    fun use() {
        GLES30.glUseProgram(programId)
        GLES30.glEnableVertexAttribArray(attribUv)
        GLES30.glEnableVertexAttribArray(attribPos)
    }

    fun delete() {
        GLES30.glDeleteProgram(programId)
    }
}