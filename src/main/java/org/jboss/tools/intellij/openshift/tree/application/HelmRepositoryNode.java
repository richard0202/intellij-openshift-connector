/*******************************************************************************
 * Copyright (c) 2024 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v2.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 * Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.intellij.openshift.tree.application;

import org.jboss.tools.intellij.openshift.utils.helm.HelmRepository;

public class HelmRepositoryNode extends BaseNode<HelmRepositoriesNode> {

    private final HelmRepository repository;

    public HelmRepositoryNode(ApplicationsRootNode root, HelmRepositoriesNode parent, HelmRepository repository) {
        super(root, parent, repository.getName());
        this.repository = repository;
    }

    public HelmRepository getRepository() {
        return repository;
    }
}
