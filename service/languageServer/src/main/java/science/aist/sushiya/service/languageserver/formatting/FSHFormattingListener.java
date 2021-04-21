/*
 * Copyright (c) 2021 the original author or authors.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package science.aist.sushiya.service.languageserver.formatting;

import org.antlr.v4.runtime.tree.TerminalNode;
import science.aist.sushiya.service.languageserver.parser.FSHBaseListener;
import science.aist.sushiya.service.languageserver.parser.FSHParser;

/**
 * <p>The FSHFormattingListener listens to the {@link FSHParser}, and creates a formatted text, which will be used by the {@link FormattingProvider}</p>
 *
 * @author SophieBauernfeind
 */
public class FSHFormattingListener extends FSHBaseListener {
    private String formattedText = "";

    public String getFormattedText() {
        return formattedText;
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        //Token with type -1 is a end of file token,
        // which can be ignored when creating a text
        if (node.getSymbol().getType() != -1) {
            formattedText += node.getText() + " ";
        }
    }

    @Override
    public void enterParent(FSHParser.ParentContext ctx) {
        formattedText += "\n\t";
    }

    @Override
    public void enterDescription(FSHParser.DescriptionContext ctx) {
        formattedText += "\n\t";
    }

    @Override
    public void exitExpression(FSHParser.ExpressionContext ctx) {
        formattedText += "\n\t";
    }

    @Override
    public void enterId(FSHParser.IdContext ctx) {
        formattedText += "\n\t";
    }

    @Override
    public void enterXpath(FSHParser.XpathContext ctx) {
        formattedText += "\n\t";
    }

    @Override
    public void enterSeverity(FSHParser.SeverityContext ctx) {
        formattedText += "\n\t";
    }

    @Override
    public void enterInstanceOf(FSHParser.InstanceOfContext ctx) {
        formattedText += "\n\t";
    }

    @Override
    public void enterUsage(FSHParser.UsageContext ctx) {
        formattedText += "\n\t";
    }

    @Override
    public void enterMixins(FSHParser.MixinsContext ctx) {
        formattedText += "\n\t";
    }

    @Override
    public void enterSource(FSHParser.SourceContext ctx) {
        formattedText += "\n\t";
    }

    @Override
    public void enterTarget(FSHParser.TargetContext ctx) {
        formattedText += "\n\t";
    }

    @Override
    public void enterTitle(FSHParser.TitleContext ctx) {
        formattedText += "\n\t";
    }

    @Override
    public void enterCardRule(FSHParser.CardRuleContext ctx) {
        formattedText += "\n\t";
    }

    @Override
    public void enterFlagRule(FSHParser.FlagRuleContext ctx) {
        formattedText += "\n\t";
    }

    @Override
    public void enterValueSetRule(FSHParser.ValueSetRuleContext ctx) {
        formattedText += "\n\t";
    }

    @Override
    public void enterVsRule(FSHParser.VsRuleContext ctx) {
        formattedText += "\n\t";
    }

    @Override
    public void enterFixedValueRule(FSHParser.FixedValueRuleContext ctx) {
        formattedText += "\n\t";
    }

    @Override
    public void enterContainsRule(FSHParser.ContainsRuleContext ctx) {
        formattedText += "\n\t";
    }

    @Override
    public void enterOnlyRule(FSHParser.OnlyRuleContext ctx) {
        formattedText += "\n\t";
    }

    @Override
    public void enterObeysRule(FSHParser.ObeysRuleContext ctx) {
        formattedText += "\n\t";
    }

    @Override
    public void enterCaretValueRule(FSHParser.CaretValueRuleContext ctx) {
        formattedText += "\n\t";
    }

    @Override
    public void enterMappingRule(FSHParser.MappingRuleContext ctx) {
        formattedText += "\n\t";
    }

    @Override
    public void enterInsertRule(FSHParser.InsertRuleContext ctx) {
        formattedText += "\n\t";
    }

    @Override
    public void enterVsComponent(FSHParser.VsComponentContext ctx) {
        super.enterVsComponent(ctx);
    }

    @Override
    public void enterEntity(FSHParser.EntityContext ctx) {
        //if its not the start of the new text
        if (formattedText.length() != 0) {
            formattedText += "\n\n";
        }
    }
}
