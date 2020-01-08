package dev.eastar.branch.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import dev.eastar.branch.R
import dev.eastar.branch.presenter.BranchViewModel
import eastar.base.BFragment
import javax.inject.Inject

class BranchMain : BFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.branch_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parentFragmentManager.commit(true) {
            replace(R.id.branch_container, BranchMap())
        }
    }
}
